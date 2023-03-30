package com.johnbryce.service;

import com.johnbryce.entity.Vehicle;
import com.johnbryce.mapper.AppMapper;
import com.johnbryce.repository.ClientRepository;
import com.johnbryce.repository.VehicleRepository;
import com.johnbryce.web.dto.ClientDto;
import com.johnbryce.web.dto.VehicleDto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoRestServiceImpl implements AutoRestService {

    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;
    private final AppMapper mapper;

    @Override
    public Optional<VehicleDto> insert(VehicleDto dto) {
        UUID uuid = dto.getUuid();

        Optional<Vehicle> optVehicle = vehicleRepository.findByUuid(uuid);

        Vehicle vehicle;

        if (optVehicle.isEmpty()) {
            vehicle = mapper.map(dto);
        } else {
            vehicle = optVehicle.get();
        }
        return Optional.ofNullable(mapper.map(vehicleRepository.save(vehicle)));
    }

    @Override
    public List<ClientDto> getAllClientsWithVehicles() {
        return clientRepository.findByVehicleNotNull()
                               .stream()
                               .map(mapper::map)
                               .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> getAllClientsWithoutVehicles() {
        return clientRepository.findAllByVehicleIsNull()
                               .stream()
                               .map(mapper::map)
                               .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getAllAvailableVehicle() {
        return toVehicleDto(vehicleRepository.findAllAvailableVehicle());
    }

    @Override
    public List<VehicleDto> getVehicleByPriceToDayLessThan(BigDecimal price) {
        return toVehicleDto(vehicleRepository.findVehicleByPriceToDayLessThan(price));
    }

    private List<VehicleDto> toVehicleDto(List<Vehicle> vehicles) {
        return vehicles.stream()
                       .map(mapper::map)
                       .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID id) {
        vehicleRepository.deleteByUuid(id);
    }
}
