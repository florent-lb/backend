package com.extia.ws.server;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.restassured.RestAssured;
import lombok.extern.java.Log;

@Log
@RequestScoped
public class KeycloakUtils {

    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String oidcServerUrl;
    @ConfigProperty(name = "quarkus.oidc.credentials.secret")
    String oidcClientSecret;
    @ConfigProperty(name = "quarkus.oidc.client-id")
    String oidcClientId;

    @ConfigProperty(name = "rtp.user.consultant.name")
    String consultantName;
    @ConfigProperty(name = "rtp.user.consultant.password")
    String consultantPwd;

    protected String getConsultantToken() {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("username", consultantName);
        params.put("password", consultantPwd);
        params.put("client_id", oidcClientId);
        params.put("client_secret", oidcClientSecret);

        log.severe("Before Token acquire : ");
        try (Jsonb jsonb = JsonbBuilder.create()) {
            String token = RestAssured.given()
                    .formParams(params)
                    .post(oidcServerUrl + "/protocol/openid-connect/token")
                    .asString();
            log.severe("Token acquire : " + token);
            return jsonb.fromJson(token, Map.class).get("access_token").toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
