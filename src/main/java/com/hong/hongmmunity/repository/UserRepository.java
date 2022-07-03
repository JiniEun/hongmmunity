package com.hong.hongmmunity.repository;

import com.hong.hongmmunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);

    Long deleteUserByUserEmail(String email);

    Boolean existsByUserEmail(String email);
}
