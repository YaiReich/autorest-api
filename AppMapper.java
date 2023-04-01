package com.johnbryce.mapper;

import com.johnbryce.entity.Client;
import com.johnbryce.entity.Vehicle;
import com.johnbryce.web.dto.ClientDto;
import com.johnbryce.web.dto.VehicleDto;

public interface AppMapper {
    Client map(ClientDto dto);


    Vehicle map(VehicleDto dto);

    VehicleDto map(Vehicle vehicle);
}
