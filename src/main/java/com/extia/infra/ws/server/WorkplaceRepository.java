package com.extia.infra.ws.server;

import javax.enterprise.context.ApplicationScoped;

import com.extia.infra.jpa.WorkPlaceEntity;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

@ApplicationScoped
public class WorkplaceRepository implements PanacheRepositoryBase<WorkPlaceEntity,Long> {
    
}
