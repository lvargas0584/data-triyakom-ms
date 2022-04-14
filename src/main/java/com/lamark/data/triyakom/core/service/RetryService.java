package com.lamark.data.triyakom.core.service;

import com.lamark.shared.dto.RetryDto;

import java.util.List;

public interface RetryService {

    RetryDto findRetryById(Long id);

    void saveRetry(RetryDto retryDto);

    void updateRetry (RetryDto retryDto);

    List<RetryDto> findByHourAndDateRetryAndEnableIsTrue();
}