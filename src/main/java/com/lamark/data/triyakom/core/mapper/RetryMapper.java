package com.lamark.data.triyakom.core.mapper;

import com.lamark.data.triyakom.core.entity.RetryEntity;
import com.lamark.shared.dto.RetryDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "cdi")
public interface RetryMapper {

    RetryDto toDto(RetryEntity userEntity)  ;

    RetryEntity toEntity(RetryDto userDto);
}
