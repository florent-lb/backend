package com.extia.ws.server;

import com.extia.infra.jpa.WorkPlaceEntity;
import com.extia.infra.jpa.WorkplaceRepository;
import com.extia.infra.ws.server.WorkPlacesDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import io.smallrye.mutiny.Uni;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@QuarkusTest
public class WorkplaceRessourceTest {
    
    Jsonb jsonb;

    @Inject
    KeycloakUtils keycloakUtils;

    @InjectMock
    WorkplaceRepository repository;

    @BeforeEach
    public void setupEach()
    {
        jsonb = JsonbBuilder.create();
    }

    @AfterEach
    public void afterEach() throws Exception
    {
        jsonb.close();
    }

    @DisplayName("GET : /workplace")
    @Test
    public void getWorkPlaces_whenCall_ShoulReturnListOfWorkplace()
    {
        WorkPlaceEntity entity = new WorkPlaceEntity();
        entity.setAgency("OUEST");
        entity.setCity("TOURS");
        entity.setName("EXTIA VAL DE LOIRE - HQ1");
        entity.setIdWorkplace(1);

        Mockito.when(repository.listAll()).thenReturn(Uni.createFrom().item(List.of(entity)));

        WorkPlacesDto dto =jsonb.fromJson(RestAssured.given()
        .auth().oauth2(keycloakUtils.getConsultantToken())
        .get("workplace")
        .asString(),WorkPlacesDto.class);
        
        assertThat(dto.getWorkplaces())
        .isNotNull()
        .hasSizeGreaterThan(0);        
    }

}
