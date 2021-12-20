package com.extia.infra.ws.server;

import lombok.Data;

@Data
public class WorkPlaceDto {
    
    private Integer idWorkplace;

    private String name;
    
    private String city;
    
    private String agency;

}
