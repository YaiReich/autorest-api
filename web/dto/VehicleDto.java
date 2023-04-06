package com.johnbryce.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleDto {
    @JsonProperty("id")
    private final UUID uuid;
    private final String manufacturerName;
    private final String modelName;
    private final BigDecimal priceToDay;
    private final long totalKmDistance;
    private boolean available;
}
