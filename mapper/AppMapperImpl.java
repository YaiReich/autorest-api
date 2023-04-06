package com.johnbryce.mapper;

import com.johnbryce.entity.Client;
import com.johnbryce.entity.Vehicle;
import com.johnbryce.web.dto.ClientDto;
import com.johnbryce.web.dto.VehicleDto;

import org.springframework.stereotype.Component;

@Component
public class AppMapperImpl implements AppMapper {
    @Override
    public Client map(ClientDto dto) {
        return Client.builder()
                     .uuid(dto.getUuid())
                     .clientName(dto.getClientName())
                     .build();
    }

    @Override
    public ClientDto map(Client client) {
        return ClientDto.builder()
                        .uuid(client.getUuid())
                        .clientName(client.getClientName())
                        .build();
    }

    @Override
    public Vehicle map(VehicleDto dto) {
        return Vehicle.builder()
                      .uuid(dto.getUuid())
                      .manufacturerName(dto.getManufacturerName())
                      .modelName(dto.getModelName())
                      .totalKmDistance(dto.getTotalKmDistance())
                      .priceToDay(dto.getPriceToDay())
                      .available(dto.isAvailable())
                      .build();
    }

    @Override
        public VehicleDto map(Vehicle vehicle) {
            return VehicleDto.builder()
                             .uuid(vehicle.getUuid())
                             .manufacturerName(vehicle.getManufacturerName())
                             .modelName(vehicle.getModelName())
                             .totalKmDistance(vehicle.getTotalKmDistance())
                             .priceToDay(vehicle.getPriceToDay())
                             .available(vehicle.isAvailable())
                             .build();
    }
}
