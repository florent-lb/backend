package com.extia.domain;

import com.extia.infra.ws.server.WorkPlaceDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface WorkplaceDtoMapper {
    
    WorkPlaceDto map(WorkPlace workPlace);

}
