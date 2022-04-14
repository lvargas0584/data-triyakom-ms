package com.lamark.data.triyakom.core.service.impl;

import com.lamark.data.triyakom.core.entity.JobsControlEntity;
import com.lamark.data.triyakom.core.mapper.JobsControlMapper;
import com.lamark.data.triyakom.core.repository.JobsControlRepository;
import com.lamark.data.triyakom.core.service.JobsControlService;
import com.lamark.shared.dto.JobsControlDto;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class JobsControlServiceImpl implements JobsControlService {

    @Inject
    JobsControlRepository jobsControlRepository;

    @Inject
    JobsControlMapper jobsControlMapper;

    @Override
    public JobsControlDto findByOperatorAndProcess(Integer operator, Integer process) {
        JobsControlEntity jobsControl = jobsControlRepository.findByOperatorAndProcess(operator, process);
        return jobsControl == null ? new JobsControlDto() : jobsControlMapper.toDto(jobsControl) ;
    }

    @Override
    @Transactional
    public void saveJobsControl(JobsControlDto jobsControlDto) {
        JobsControlEntity jobsControlEntity =   jobsControlMapper.toEntity(jobsControlDto);
        jobsControlRepository.persist(jobsControlEntity);
    }

    @Override
    @Transactional
    public void updateJobsControl (JobsControlDto jobsControlDto) {
        JobsControlEntity jobsControlEntity = jobsControlRepository.findById(jobsControlDto.getId());
        jobsControlEntity.setStartDate(jobsControlDto.getStartDate());
        jobsControlEntity.setEndDate(jobsControlDto.getEndDate());
        jobsControlEntity.setOperator(jobsControlDto.getOperator());
        jobsControlEntity.setProcess(jobsControlDto.getProcess());
        jobsControlRepository.persist(jobsControlEntity);
    }

}
