package com.lamark.data.triyakom.core.service.impl;

import com.lamark.architecture.corems.exception.BaseException;
import com.lamark.architecture.corems.exception.ExceptionHelper;

import com.lamark.data.triyakom.core.entity.RegistrationEntity;
import com.lamark.data.triyakom.core.mapper.RegistrationMapper;
import com.lamark.data.triyakom.core.repository.RegistrationRepository;
import com.lamark.data.triyakom.core.service.RegistrationService;
import com.lamark.shared.dto.RegistrationDto;
import io.quarkus.arc.ArcUndeclaredThrowableException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class RegistrationServiceImpl implements RegistrationService {

    @Inject
    RegistrationRepository registrationRepository;

    @Inject
    RegistrationMapper registrationMapper;

    @Override
    @Transactional
    public String createRegistration(RegistrationDto registration) throws BaseException {
        RegistrationEntity entity = registrationMapper.toEntity(registration);
        try {
            registrationRepository.persist(entity);
            return entity.getId();
        } catch (ArcUndeclaredThrowableException e) {
            throw ExceptionHelper.buildGenericException("ERROR AL GUARDAR EN triyacom_subscription");
        }
    }

    @Override
    @Transactional
    public String saveRegistration(RegistrationDto registrationDto){

        RegistrationEntity registrationEntity = new RegistrationEntity();

        if (registrationDto.getId() != null && !registrationDto.getId().isEmpty())
            registrationEntity = registrationRepository.findById(registrationDto.getId());

        registrationEntity.setDeliveryPayload(registrationDto.getDeliveryPayload() == null ? registrationEntity.getDeliveryPayload() : registrationDto.getDeliveryPayload());
        registrationEntity.setDeliveryStatus(registrationDto.getDeliveryStatus() == null ? registrationEntity.getDeliveryStatus() : registrationDto.getDeliveryStatus());
        registrationEntity.setDeliveryDate(registrationDto.getDeliveryDate() == null ? registrationEntity.getDeliveryDate() : registrationDto.getDeliveryDate());
        registrationEntity.setChargeRecord(registrationDto.getChargeRecord() == null ? registrationEntity.getChargeRecord() : registrationDto.getChargeRecord());
        registrationEntity.setPushId(registrationDto.getPushId() == null ? registrationEntity.getPushId() : registrationDto.getPushId());
        registrationEntity.setPushStatus(registrationDto.getPushStatus() == null ? registrationEntity.getPushStatus() : registrationDto.getPushStatus());
        registrationEntity.setRenewDate(registrationDto.getRenewDate() == null ? registrationEntity.getRenewDate() : registrationDto.getRenewDate());
        registrationEntity.setMsisdn(registrationDto.getMsisdn() == null ? registrationEntity.getMsisdn() : registrationDto.getMsisdn());
        registrationEntity.setOperator(registrationDto.getOperator() == null ? registrationEntity.getOperator() : registrationDto.getOperator());
        registrationEntity.setType(registrationDto.getType() == null ? registrationEntity.getType() : registrationDto.getType());
        registrationEntity.setPayload(registrationDto.getPayload() == null ? registrationEntity.getPayload() : registrationDto.getPayload());
        registrationEntity.setDateCreated(registrationDto.getDateCreated() == null ? registrationEntity.getDateCreated() : registrationDto.getDateCreated());
        registrationEntity.setAttempt(registrationDto.getAttempt() == null ? registrationEntity.getAttempt() : registrationDto.getAttempt());
        registrationRepository.persist(registrationEntity);

        return registrationEntity.getId();
    }

    @Transactional
    public void save(RegistrationEntity registrationEntity) {
        registrationRepository.persist(registrationEntity);
    }

    public RegistrationDto findById(String id) {
        return registrationMapper.toDto(registrationRepository.findById(id));

    }

    @Override
    public RegistrationDto findByPushId(String pushId) {
        RegistrationEntity registration = registrationRepository.find("pushId = ?1", pushId).firstResult();
        return registrationMapper.toDto(registration);
    }


}
