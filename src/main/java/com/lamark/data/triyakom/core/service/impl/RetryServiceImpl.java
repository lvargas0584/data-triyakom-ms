package com.lamark.data.triyakom.core.service.impl;

import com.lamark.data.triyakom.core.entity.RetryEntity;
import com.lamark.data.triyakom.core.mapper.RetryMapper;
import com.lamark.data.triyakom.core.repository.RetryRepository;
import com.lamark.data.triyakom.core.service.RetryService;
import com.lamark.shared.dto.RetryDto;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Singleton
public class RetryServiceImpl implements RetryService {

    @Inject
    RetryRepository retryRepository;

    @Inject
    RetryMapper retryMapper;

    SimpleDateFormat MYSQL_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final String ZONE = "Asia/Jakarta";

    @Override
    public RetryDto findRetryById(Long id) {
        RetryEntity retry = retryRepository.findById(id);
        return retry == null ? new RetryDto() : retryMapper.toDto(retry) ;
    }

    @Override
    @Transactional
    public void saveRetry(RetryDto retryDto) {
        RetryEntity retryEntity =   retryMapper.toEntity(retryDto);
        retryRepository.persist(retryEntity);
    }

    @Override
    @Transactional
    public void updateRetry (RetryDto retryDto) {
        RetryEntity retryEntity = retryRepository.findById(retryDto.getId());
        retryEntity.setEnable(retryDto.isEnable());

        if(retryDto.getDateRetry() != null){
            retryEntity.setDateRetry(retryDto.getDateRetry());
        }

        if(retryDto.getHour() != null){
            retryEntity.setHour(retryDto.getHour());
        }

        retryRepository.persist(retryEntity);
    }

    @Override
    public List<RetryDto> findByHourAndDateRetryAndEnableIsTrue(){
        List<RetryDto> listRetryDtos = new ArrayList<>();
        Integer hour = HOUR_ZONE(ZONE);
        Date date = getDateWithoutTime(DATE_ZONE(ZONE));

        List<RetryEntity> list = retryRepository.findByHourAndDateRetryAndEnableIsTrue(hour, MYSQL_FORMAT.format(date));

        list.forEach(s -> {
            RetryDto dto = new RetryDto();
            dto.setId(s.getId());
            dto.setHour(s.getHour());
            dto.setEnable(s.isEnable());
            dto.setDateRetry(s.getDateRetry());
            listRetryDtos.add(dto);
        });

        return listRetryDtos;
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date DATE_ZONE(String zone) {
        return Date.from(getLocalDateTime(zone).toInstant(ZoneOffset.UTC));
    }

    public static LocalDateTime getLocalDateTime(String zone) {
        return getLocalDateTime(new Date(), zone);
    }

    public static LocalDateTime getLocalDateTime(Date date, String zone) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of(zone)).toLocalDateTime();
    }

    public static Integer HOUR_ZONE(String zone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_ZONE(zone));
        return calendar.get(11);
    }

}
