package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Engine;

import java.util.Optional;

public interface EngineServices {

    Engine addEngine(Engine engine);

    Optional<Engine> findByNumberEngine(Long numberEngine);
}
