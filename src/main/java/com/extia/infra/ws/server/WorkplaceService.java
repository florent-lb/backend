package com.extia.infra.ws.server;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.extia.domain.WorkplaceDtoMapper;
import com.extia.infra.jpa.WorkPlaceEntityMapper;

import io.smallrye.mutiny.Uni;

@RequestScoped
public class WorkplaceService {

    @Inject
    WorkPlaceEntityMapper entityMapper;
    
    @Inject
    WorkplaceDtoMapper dtoMapper;

    @Inject
    WorkplaceRepository workplaceRepository;

    public Uni<List<WorkPlaceDto>> getAll() {
        return workplaceRepository.listAll()
        .map(workplaces -> workplaces.stream().map(entityMapper::map).collect(Collectors.toList())) 
        .map(workplaces -> workplaces.stream().map(dtoMapper::map).collect(Collectors.toList()));               
    }

}
