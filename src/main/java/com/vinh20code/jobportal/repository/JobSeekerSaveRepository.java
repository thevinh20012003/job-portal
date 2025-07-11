package com.vinh20code.jobportal.repository;

import com.vinh20code.jobportal.entity.JobPostActivity;
import com.vinh20code.jobportal.entity.JobSeekerProfile;
import com.vinh20code.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}
