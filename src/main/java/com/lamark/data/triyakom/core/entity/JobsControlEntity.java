package com.lamark.data.triyakom.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "jobs_control")
public class JobsControlEntity extends PanacheEntityBase {

    @Id
    private Integer id;

    @Column
    private Integer operator;

    @Column
    private Integer process;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
