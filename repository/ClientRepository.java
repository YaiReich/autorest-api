package com.johnbryce.repository;

import com.johnbryce.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUuid (UUID uuid);

    @Modifying
    @Query("delete from Vehicle where uuid = :id")
    void deleteByUuid(UUID id);

    Set<Client> findByVehicleNotNull();

    Set<Client>findAllByVehicleIsNull();

}
