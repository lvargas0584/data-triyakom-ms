package com.lamark.data.triyakom.core.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "triyakom_user_retry_time")
public class RetryEntity extends PanacheEntityBase {

    @Id
    private Long id ;

    private Integer hour;

    private boolean enable;

    @Column(name = "date_retry")
    private Date dateRetry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getDateRetry() {
        return dateRetry;
    }

    public void setDateRetry(Date dateRetry) {
        this.dateRetry = dateRetry;
    }
}
