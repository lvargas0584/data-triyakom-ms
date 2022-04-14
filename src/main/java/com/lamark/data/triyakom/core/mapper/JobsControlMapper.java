package com.lamark.data.triyakom.core.mapper;

import com.lamark.data.triyakom.core.entity.JobsControlEntity;
import com.lamark.data.triyakom.core.entity.RetryEntity;
import com.lamark.shared.dto.JobsControlDto;
import com.lamark.shared.dto.RetryDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "cdi")
public interface JobsControlMapper {

    JobsControlDto toDto(JobsControlEntity jobsControlEntity) ;

    JobsControlEntity toEntity(JobsControlDto jobsControlDto);
}
