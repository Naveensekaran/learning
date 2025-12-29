package com.springboot.learning.repostiory;

import com.springboot.learning.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

   Optional<UserDetails> findByUserId(String UserId);

}
