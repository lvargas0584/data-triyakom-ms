package com.lamark.data.triyakom.core.repository;

import com.lamark.data.triyakom.core.entity.RetryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RetryRepository implements PanacheRepositoryBase<RetryEntity, Long> {

    public List<RetryEntity> findByHourAndDateRetryAndEnableIsTrue(Integer hour, String date) {
        return find("From RetryEntity u where  u.hour = ?1 and DATE_FORMAT(u.dateRetry,'%Y-%m-%d')  = ?2 and enable = 1",
                hour, date).list();
    }
}
