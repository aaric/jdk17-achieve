package com.sample.pojo.entity;

import com.sample.pojo.constant.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Car
 *
 * @author Aaric
 * @version 0.4.0-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private CarType type;
}
