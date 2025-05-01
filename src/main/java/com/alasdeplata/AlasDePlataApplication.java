package com.alasdeplata;

import java.util.List;
import java.util.Set;

import com.alasdeplata.models.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alasdeplata.enums.RoleEnum;
import com.alasdeplata.repository.UserRepository;
import com.alasdeplata.models.Permission;
import com.alasdeplata.models.Role;

@SpringBootApplication
public class AlasDePlataApplication {

        public static void main(String[] args) {
                SpringApplication.run(AlasDePlataApplication.class, args);
        }

        @Bean
        CommandLineRunner init(UserRepository userRepository) {
                return args -> {
                        /* Create PERMISSIONS */
                        Permission createPermission = Permission.builder()
                                        .name("CREATE")
                                        .build();

                        Permission readPermission = Permission.builder()
                                        .name("READ")
                                        .build();

                        Permission updatePermission = Permission.builder()
                                        .name("UPDATE")
                                        .build();

                        Permission deletePermission = Permission.builder()
                                        .name("DELETE")
                                        .build();

                        Permission refactorPermission = Permission.builder()
                                        .name("REFACTOR")
                                        .build();

                        /* Create ROLES */
                        Role roleAdmin = Role.builder()
                                        .roleEnum(RoleEnum.ADMIN)
                                        .permissionList(Set.of(createPermission, readPermission, updatePermission,
                                                        deletePermission))
                                        .build();

                        Role roleUser = Role.builder()
                                        .roleEnum(RoleEnum.USER)
                                        .permissionList(Set.of(createPermission, readPermission))
                                        .build();

                        Role roleInvited = Role.builder()
                                        .roleEnum(RoleEnum.INVITED)
                                        .permissionList(Set.of(readPermission))
                                        .build();

                        Role roleDeveloper = Role.builder()
                                        .roleEnum(RoleEnum.DEVELOPER)
                                        .permissionList(Set.of(createPermission, readPermission, updatePermission,
                                                        deletePermission, refactorPermission))
                                        .build();

                        /* CREATE USERS */
                        UserEntity userSantiago = UserEntity.builder()
                                        .username("santiago")
                                        .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                                        .isEnabled(true)
                                        .accountNoExpired(true)
                                        .accountNoLocked(true)
                                        .credentialNoExpired(true)
                                        .roles(Set.of(roleAdmin))
                                        .build();

                        UserEntity userDaniel = UserEntity.builder()
                                        .username("daniel")
                                        .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                                        .isEnabled(true)
                                        .accountNoExpired(true)
                                        .accountNoLocked(true)
                                        .credentialNoExpired(true)
                                        .roles(Set.of(roleUser))
                                        .build();

                        UserEntity userAndrea = UserEntity.builder()
                                        .username("andrea")
                                        .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                                        .isEnabled(true)
                                        .accountNoExpired(true)
                                        .accountNoLocked(true)
                                        .credentialNoExpired(true)
                                        .roles(Set.of(roleInvited))
                                        .build();

                        UserEntity userAnyi = UserEntity.builder()
                                        .username("anyi")
                                        .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                                        .isEnabled(true)
                                        .accountNoExpired(true)
                                        .accountNoLocked(true)
                                        .credentialNoExpired(true)
                                        .roles(Set.of(roleDeveloper))
                                        .build();

                        userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea,
                                        userAnyi));
                };
        }
}
