package com.alasdeplata.repository;

import java.util.Optional;

import com.alasdeplata.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findUserPrincipalByUsername(String username);
}
