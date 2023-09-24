package com.example.job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Optional<Job> findByIdOrService(Integer id, String service);
    Optional<Job> findById(Long id);
}
