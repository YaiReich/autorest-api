package com.johnbryce.service;

import com.johnbryce.web.dto.ClientDto;
import com.johnbryce.web.dto.VehicleDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AutoRestService {

    Optional<VehicleDto> insert(VehicleDto vehicle);

    List<ClientDto> getAllClientsWithVehicles();

    List<ClientDto> getAllClientsWithoutVehicles();

    List<VehicleDto> getAllAvailableVehicle();

    void deleteByUuid(UUID uuid);

    List<VehicleDto> getVehicleByPriceToDayLessThan(BigDecimal price);
}
