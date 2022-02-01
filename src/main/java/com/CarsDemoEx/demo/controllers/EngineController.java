package com.CarsDemoEx.demo.controllers;


import com.CarsDemoEx.demo.Dto.EngineDto;
import com.CarsDemoEx.demo.models.Engine;
import com.CarsDemoEx.demo.services.EngineServices;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/engines")
public class EngineController {

    private final EngineServices engineServices;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public EngineController(EngineServices engineServices) {
        this.engineServices = engineServices;
    }


    @PostMapping
    ResponseEntity<EngineDto> addEngine (@Valid @RequestBody EngineDto newEngine){
        Engine engine = modelMapper.map(newEngine, Engine.class);
        Engine createdEngine = engineServices.addEngine(engine);
        EngineDto mappedEngine = modelMapper.map(createdEngine, EngineDto.class);
        return ResponseEntity.ok(mappedEngine);
    }


    @GetMapping("/numberEngines")
    ResponseEntity<EngineDto> findByEngineNumber (@PathVariable(value = "numberEngine") Long id){
        Optional<Engine> optionalEngine = engineServices.findByNumberEngine(id);
        EngineDto mappedDto = modelMapper.map(optionalEngine.get(), EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }



}
