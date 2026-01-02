package com.springboot.learning.repostiory;

import com.springboot.learning.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

   Optional<Users> findByUsername(String UserId);

}
