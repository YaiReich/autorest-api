package com.johnbryce.web.controller;

import com.johnbryce.service.AutoRestService;
import com.johnbryce.web.dto.ClientDto;
import com.johnbryce.web.dto.VehicleDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/autorest")
public class AutoRestController {

    private final AutoRestService autoRestService;

    @GetMapping("/clients/withVehicles")
    public ResponseEntity<List<ClientDto>> clientsWitheVehicles() {
        return ResponseEntity.ok(autoRestService.getAllClientsWithVehicles());
    }

    @GetMapping("/clients/withoutVehicles")
    public ResponseEntity<List<ClientDto>> clientsWithoutVehicles() {
        return ResponseEntity.ok(autoRestService.getAllClientsWithoutVehicles());
    }

    @GetMapping("/vehicles/available")
    public ResponseEntity<List<VehicleDto>> allAvailableVehicle() {
        return ResponseEntity.ok(autoRestService.getAllAvailableVehicle());
    }

    @GetMapping("/vehicles/belowPrice/{price}")
    public ResponseEntity<List<VehicleDto>> allVehicleByPriceToDayLessThan(
            @PathVariable BigDecimal price) {
        return ResponseEntity.ok(autoRestService.getVehicleByPriceToDayLessThan(price));
    }

    @PostMapping("/vehicle")
    public ResponseEntity<Optional<VehicleDto>> insert(@RequestBody VehicleDto vehicle) {
        return ResponseEntity.ok(autoRestService.insert(vehicle));
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        autoRestService.deleteByUuid(uuid);
    }

}
