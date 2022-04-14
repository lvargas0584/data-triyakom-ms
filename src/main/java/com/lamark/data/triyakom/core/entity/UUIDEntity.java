//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lamark.data.triyakom.core.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
@Data
public class UUIDEntity extends BaseEntity<String> {
    @Id
    @Column(
        length = 36
    )
    @GeneratedValue(
        generator = "system-uuid"
    )
    @GenericGenerator(
        name = "system-uuid",
        strategy = "uuid"
    )
    private String id;

}
