package com.sample.mapstruct;

import com.sample.pojo.constant.CarType;
import com.sample.pojo.dto.CarDto;
import com.sample.pojo.entity.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CarMappingTest
 *
 * @author Aaric
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
public class CarMappingTest {

    @Test
    public void testCarToCarDto() {
        System.err.println("testCarToCarDto");
        Car car = new Car("BBA", 5, CarType.EV);
        CarDto carDto = CarMapping.INSTANCE.carToCarDto(car);
        assertThat(carDto).isNotNull();
        assertThat(carDto.getType()).isEqualTo("EV");
    }
}
