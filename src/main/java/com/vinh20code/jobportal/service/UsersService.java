package com.vinh20code.jobportal.service;

import com.vinh20code.jobportal.entity.JobSeekerProfile;
import com.vinh20code.jobportal.entity.RecruiterProfile;
import com.vinh20code.jobportal.entity.Users;
import com.vinh20code.jobportal.repository.JobSeekerProfileRepository;
import com.vinh20code.jobportal.repository.RecruiterProfileRepository;
import com.vinh20code.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    @Autowired
    public UsersService(UserRepository usersRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository recruiterProfileRepository) {
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersRepository = usersRepository;
    }
    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
