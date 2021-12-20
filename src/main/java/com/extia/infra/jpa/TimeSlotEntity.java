package com.extia.infra.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "workplace")
@Entity
@EqualsAndHashCode(of = "idTimeSlot")
@Data
public class TimeSlotEntity {
    
    @Id
    @Column(name = "id_timeslot")
    private Long idTimeSlot;

    @Column(name = "date_slot")
    private LocalDate dateSlot;

    @ManyToOne
    @JoinColumn(name = "id_workplace")
    private WorkPlaceEntity idWorkPlace;

    @Column(name = "id_type_slot")
    private Short idTypeSlot;

}
