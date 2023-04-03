package com.project.calendar.repository;

import com.project.calendar.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserUsername(String username);

    boolean existsByUserUsername(String username);

}
