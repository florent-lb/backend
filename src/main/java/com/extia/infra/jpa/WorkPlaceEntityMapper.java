package com.extia.infra.jpa;

import com.extia.domain.WorkPlace;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface WorkPlaceEntityMapper {
    
    WorkPlace map(WorkPlaceEntity workPlace);

}
