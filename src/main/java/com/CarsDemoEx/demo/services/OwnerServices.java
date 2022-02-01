package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OwnerServices {
    Owner addOwner(Owner owner);

    Optional<Owner> findById(Long id);

    Page<Owner> findAll(Pageable pageable);
}
