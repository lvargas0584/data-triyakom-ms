package com.lamark.data.triyakom.core.service;

import com.lamark.shared.dto.JobsControlDto;

public interface JobsControlService {

    JobsControlDto findByOperatorAndProcess(Integer operator, Integer process);

    void saveJobsControl(JobsControlDto jobsControlDto);

    void updateJobsControl(JobsControlDto jobsControlDto) ;
}