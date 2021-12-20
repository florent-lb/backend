package com.extia.infra.ws.server;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;

@Path("workplace")
@Authenticated
public class WorkplaceRessource {
    
    @Inject
    WorkplaceService workplaceService;

    @GET
    public Uni<WorkPlacesDto> getWorkplace()
    {
        return workplaceService.getAll()
        .map(list -> new WorkPlacesDto(list)) ;
    }
}
