package com.lamark.data.triyakom.core.entity;

import com.google.gson.Gson;
import com.lamark.shared.dto.AttemptType;
import com.lamark.shared.dto.DeliveryData;
import com.lamark.shared.dto.RegistrationData;
import com.lamark.shared.dto.SendMTTag;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table( name = "triyacom_subscription")
@TypeDefs({@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
), @TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)})
@Data
public class RegistrationEntity   {

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

    @Column
    private String msisdn;

    @Column
    private String operator;

    @Enumerated(EnumType.ORDINAL)
    private SendMTTag type;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private RegistrationData payload;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "charge_record")
    private Long chargeRecord;

    @Column(name = "push_id")
    private String pushId;

    @Column(name = "push_status")
    private Integer pushStatus;

    @Column(name = "date_renew")
    private Date renewDate;

    @Enumerated(EnumType.ORDINAL)
    private AttemptType attempt;

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "delivery_payload")
    private DeliveryData deliveryPayload;

    @Column(name = "delivery_status")
    private Integer deliveryStatus;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    public String toString(){
        return new Gson().toJson(this);
    }

}
