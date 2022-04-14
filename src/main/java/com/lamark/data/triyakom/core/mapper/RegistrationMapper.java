package com.lamark.data.triyakom.core.mapper;


import com.lamark.data.triyakom.core.entity.RegistrationEntity;
import com.lamark.shared.dto.RegistrationDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "cdi")
public interface RegistrationMapper {

    RegistrationDto toDto(RegistrationEntity userEntity)  ;

    RegistrationEntity toEntity(RegistrationDto userDto);
}
