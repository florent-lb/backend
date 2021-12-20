package com.extia.infra.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ref_time_slot")
@EqualsAndHashCode(of = "idTypeSlot")
public class RefTypeSlotEntity {
    
    @Id
    @Column(name = "id_type_slot")
    private Short idTypeSlot;
    
    @Column(name = "ref_type_slot")
    private String refTypeSlot;

}
