package com.sunnyportfoliowebsite.backend.repository;

import com.sunnyportfoliowebsite.backend.model.EmailHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailHistoryRecord, Long> {
}
