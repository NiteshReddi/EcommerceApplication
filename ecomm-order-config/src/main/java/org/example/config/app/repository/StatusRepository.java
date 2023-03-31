package org.example.config.app.repository;

import org.example.config.app.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository  extends JpaRepository<Status, Long> {
}
