package com.dxc.customermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.customermanagementservice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
