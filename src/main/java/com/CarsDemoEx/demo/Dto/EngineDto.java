package com.CarsDemoEx.demo.Dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class EngineDto {

    @Pattern(regexp="\\d{6}")
    @NotEmpty(message = "Please provide me engine number")
    private int numberEngine;

    @Max(13000)
    @Min(600)
    @NotEmpty(message = "Please provide me engine volume")
    private int volumeEngine;

    @NotEmpty(message = "Please provide me horse power")
    private int horsePower;
}
