package com.extia.infra.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(of = "idUser")
public class UserEntity {
    
    @Id
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "mail")
    @Email
    private String mail;

    @Column(name = "name",length = 255)
    private String name;
}
