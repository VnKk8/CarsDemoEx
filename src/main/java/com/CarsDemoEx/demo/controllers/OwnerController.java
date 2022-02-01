package com.CarsDemoEx.demo.controllers;


import com.CarsDemoEx.demo.Dto.OwnerDto;
import com.CarsDemoEx.demo.exceptions.OwnerNotFoundException;
import com.CarsDemoEx.demo.models.Owner;
import com.CarsDemoEx.demo.services.OwnerServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerServices ownerServices;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }


    @PostMapping
    ResponseEntity<OwnerDto> addOwner (@Valid @RequestBody OwnerDto newOwner){
        Owner owner = modelMapper.map(newOwner, Owner.class);
        Owner createdOwner = ownerServices.addOwner(owner);
        OwnerDto mappedDtoOwner = modelMapper.map(createdOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedDtoOwner);
    }

    @GetMapping("/{id}")
    ResponseEntity<OwnerDto> findById (@PathVariable(value = "id") Long id){
        Optional<Owner> optionalOwner = ownerServices.findById(id);
        if(optionalOwner.isEmpty()){

            throw new OwnerNotFoundException(id);
        }
        OwnerDto mappedDtoOwner = modelMapper.map(optionalOwner.get(), OwnerDto.class);
        return ResponseEntity.ok(mappedDtoOwner);
    }

    @GetMapping
    public Page<Owner> findAll(Pageable pageable){
        return  ownerServices.findAll(pageable);
    }

}
