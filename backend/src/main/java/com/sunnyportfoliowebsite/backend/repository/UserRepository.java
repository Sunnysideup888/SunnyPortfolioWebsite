package com.sunnyportfoliowebsite.backend.repository;

import com.sunnyportfoliowebsite.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
