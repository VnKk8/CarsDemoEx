package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Owner;
import com.CarsDemoEx.demo.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServicesImpl implements OwnerServices {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServicesImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Page<Owner> findAll(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }


}
