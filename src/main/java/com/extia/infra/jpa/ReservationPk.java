package com.extia.infra.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ReservationPk implements Serializable{
    
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_time_slot")
    private Integer idTimeSlot;

}
