package com.extia.infra.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "workplace")
@Entity
@EqualsAndHashCode(of = "idWorkplace",callSuper = false)
@Data
public class WorkPlaceEntity extends PanacheEntityBase {

    @Id
    @Column(name = "id_workplace")
    private Integer idWorkplace;

    @Column(name = "name")
    private String name;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "agency")
    private String agency;

}
