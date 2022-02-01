package com.CarsDemoEx.demo.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CarDto {

    @Size(min = 2, message = "This is not a brand")
    @NotEmpty(message = "Please provide me a brand name")
    private String branCar;

    @Size(min = 2, message = "This is not a model")
    @NotEmpty(message = "Please provide me a model name")
    private String modelCar;

    @Pattern(regexp = "^((0[1-9])|(1[0-2]))\\/(\\d{4})$")
    @NotEmpty(message = "Please provide me a year")
    private int yearMade;

    @Size(min = 7, max = 8, message = "This is not a plate number")
    @NotEmpty(message = "Please provide me a plate number")
    private String plateNumber;
}
