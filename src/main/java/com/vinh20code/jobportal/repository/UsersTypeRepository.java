package com.vinh20code.jobportal.repository;

import com.vinh20code.jobportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {

    // Additional query methods can be defined here if needed
    // For example, to find a user type by its name:
    // Optional<UsersType> findByUserTypeName(String userTypeName);
}
