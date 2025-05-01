package com.alasdeplata.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.alasdeplata.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alasdeplata.dto.auth.AuthCreateUserRequest;
import com.alasdeplata.dto.auth.AuthLoginRequest;
import com.alasdeplata.dto.auth.AuthResponse;
import com.alasdeplata.repository.UserRepository;
import com.alasdeplata.models.Role;
import com.alasdeplata.repository.RoleRepository;
import com.alasdeplata.common.JwtUtils;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private JwtUtils jwtUtils;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserEntity user = userRepository.findUserPrincipalByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "El usuario " + username + " no existe."));

                List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

                user.getRoles().forEach(role -> authorityList
                                .add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

                user.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(
                                permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

                return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
                                user.isAccountNoExpired(), user.isCredentialNoExpired(),
                                user.isAccountNoLocked(),
                                authorityList);
        }

        public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
                String username = authLoginRequest.username();
                String password = authLoginRequest.password();

                Authentication authentication = this.authenticate(username, password);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                String accessToken = jwtUtils.createToken(authentication);
                AuthResponse authResponse = new AuthResponse(username, "User logged successfuly", accessToken, true);
                return authResponse;
        }

        public Authentication authenticate(String username, String password) {
                UserDetails userDetails = this.loadUserByUsername(username);

                if (userDetails == null) {
                        throw new BadCredentialsException("Invalid username or password");
                }

                if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                        throw new BadCredentialsException("Invalid password");
                }

                return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(),
                                userDetails.getAuthorities());

        }

        public AuthResponse createUser(AuthCreateUserRequest authCreateUserRequest) {
                String username = authCreateUserRequest.username();
                String password = authCreateUserRequest.password();
                List<String> roleRequest = authCreateUserRequest.roleRequest().roleListName();

                Set<Role> roleEntitiesSet = roleRepository.findRoleEntitiesByRoleEnumIn(roleRequest).stream()
                                .collect(Collectors.toSet());

                if (roleEntitiesSet.isEmpty()) {
                        throw new IllegalArgumentException("The roles specified does not exist.");
                }

                UserEntity user = UserEntity.builder()
                                .username(username)
                                .password(passwordEncoder.encode(password))
                                .firstName(authCreateUserRequest.firstName())
                                .lastName(authCreateUserRequest.lastName())
                                .email(authCreateUserRequest.email())
                                .roles(roleEntitiesSet)
                                .isEnabled(true)
                                .accountNoLocked(true)
                                .accountNoExpired(true)
                                .credentialNoExpired(true)
                                .build();

                UserEntity userCreated = userRepository.save(user);

                ArrayList<SimpleGrantedAuthority> authorityList = new ArrayList<>();

                userCreated.getRoles().forEach(role -> authorityList
                                .add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

                userCreated.getRoles()
                                .stream()
                                .flatMap(role -> role.getPermissionList().stream())
                                .forEach(permission -> authorityList
                                                .add(new SimpleGrantedAuthority(permission.getName())));

                Authentication authentication = new UsernamePasswordAuthenticationToken(userCreated.getUsername(),
                                userCreated.getPassword(), authorityList);

                String accessToken = jwtUtils.createToken(authentication);
                AuthResponse authResponse = new AuthResponse(userCreated.getUsername(), "User created successfuly",
                                accessToken, true);

                return authResponse;
        }
}
