package com.lamark.data.triyakom.core.service;

import com.lamark.architecture.corems.exception.BaseException;
import com.lamark.shared.dto.RegistrationDto;

public interface RegistrationService {

    String createRegistration(RegistrationDto registration) throws BaseException;

    String saveRegistration(RegistrationDto registration);

    RegistrationDto findByPushId(String pushId);
}