package com.vinh20code.jobportal.repository;

import com.vinh20code.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
