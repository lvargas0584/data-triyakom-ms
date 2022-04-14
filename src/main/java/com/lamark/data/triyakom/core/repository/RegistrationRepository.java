package com.lamark.data.triyakom.core.repository;

import com.lamark.data.triyakom.core.entity.RegistrationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegistrationRepository implements PanacheRepositoryBase<RegistrationEntity, String> {
}
