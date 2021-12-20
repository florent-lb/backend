package com.extia.infra.ws.server;

import java.util.Collection;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class WorkPlacesDto {
    
    @NonNull
    private Collection<WorkPlaceDto> workplaces;
           
}
