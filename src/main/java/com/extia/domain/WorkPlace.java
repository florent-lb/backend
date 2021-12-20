package com.extia.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class WorkPlace {
    
    @NonNull
    private Integer idWorkplace;

    @NonNull
    private String name;
    
    @NonNull
    private String city;
    
    @NonNull
    private String agency;

}
