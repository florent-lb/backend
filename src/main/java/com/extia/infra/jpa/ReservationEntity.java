package com.extia.infra.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "reservation")
@EqualsAndHashCode(of = "pk")
@Data
public class ReservationEntity {
    
    @EmbeddedId
    private ReservationPk pk;

    @ManyToOne
    @JoinColumn(name = "id_user",updatable = false, insertable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_time_slot",updatable = false, insertable = false)
    private TimeSlotEntity timeSlot;
}
