package com.lamark.data.triyakom.core.repository;

import com.lamark.data.triyakom.core.entity.JobsControlEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobsControlRepository implements PanacheRepositoryBase<JobsControlEntity, Integer> {

    public JobsControlEntity findByOperatorAndProcess(Integer operator, Integer process) {
        return find("From JobsControlEntity u where  u.operator = ?1 and u.process = ?2",
                operator, process).singleResult();
    }
}
