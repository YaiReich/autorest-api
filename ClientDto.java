package com.johnbryce.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    @JsonProperty("id")
    private final UUID uuid;
    private final String clientName;
}






