package com.sample.mapstruct;

import com.sample.pojo.dto.CarDto;
import com.sample.pojo.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CarMapping
 *
 * @author Aaric
 * @version 1.0.0-SNAPSHOT
 */
@Mapper
public interface CarMapping {

    CarMapping INSTANCE = Mappers.getMapper(CarMapping.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}
