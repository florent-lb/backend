package com.extia.infra.jpa;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

@ApplicationScoped
public class WorkplaceRepository implements PanacheRepositoryBase<WorkPlaceEntity,Long> {
    
}
