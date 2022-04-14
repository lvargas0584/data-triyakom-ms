//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lamark.data.triyakom.core.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@TypeDefs({@TypeDef(
    name = "json",
    typeClass = JsonStringType.class
), @TypeDef(
    name = "jsonb",
    typeClass = JsonBinaryType.class
)})
@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable {
    public BaseEntity() {
    }

}
