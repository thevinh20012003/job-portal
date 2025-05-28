package com.vinh20code.jobportal.repository;

import com.vinh20code.jobportal.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {

    // Custom query methods can be added here if needed
    // For example, to find a recruiter profile by user account ID:
    // Optional<RecruiterProfile> findByUserAccountId(int userAccountId);

}