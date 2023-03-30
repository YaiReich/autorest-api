package com.johnbryce.repository;

import com.johnbryce.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByUuid(UUID uuid);

    @Modifying
    @Query("delete from Vehicle where uuid = :id")
    void deleteByUuid(UUID id);

    @Query("select v from Vehicle v where  v.client is null")
    List<Vehicle> findAllAvailableVehicle();

    @Query("select v from Vehicle v where v.priceToDay < :price")
    List<Vehicle> findVehicleByPriceToDayLessThan(BigDecimal price);
}