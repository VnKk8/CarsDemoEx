package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Engine;
import com.CarsDemoEx.demo.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineServicesImpl implements EngineServices {


    private final EngineRepository engineRepository;

    @Autowired
    public EngineServicesImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public Engine addEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Optional<Engine> findByNumberEngine(Long numberEngine) {
        return engineRepository.findById(numberEngine);
    }
}
