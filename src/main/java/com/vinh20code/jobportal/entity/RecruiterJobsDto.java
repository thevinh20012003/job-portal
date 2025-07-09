package com.vinh20code.jobportal.entity;

public class RecruiterJobsDto {
    private Long totalCandidates;
    private Long jobPostId;
    private String jobTitle;
    private JobLocation jobLocationId;
    private JobCompany jobCompanyId;

    @Override
    public String toString() {
        return "RecruiterJobDto{" +
                "totalCandidates=" + totalCandidates +
                ", jobPostId=" + jobPostId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobLocationId=" + jobLocationId +
                ", jobCompanyId=" + jobCompanyId +
                '}';
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public Long getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(Long jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public void setJobLocationId(JobLocation jobLocationId) {
        this.jobLocationId = jobLocationId;
    }

    public JobCompany getJobCompanyId() {
        return jobCompanyId;
    }

    public void setJobCompanyId(JobCompany jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
    }

    public RecruiterJobsDto(Long totalCandidates, Long jobPostId, String jobTitle, JobLocation jobLocationId, JobCompany jobCompanyId) {
        this.totalCandidates = totalCandidates;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.jobLocationId = jobLocationId;
        this.jobCompanyId = jobCompanyId;
    }

    public RecruiterJobsDto() {
    }
}
