package com.sample.pojo.constant;

import cn.hutool.core.util.EnumUtil;

/**
 * CarType
 *
 * @author Aaric
 * @version 0.4.0-SNAPSHOT
 */
public enum CarType {

    // ICEV, HEV, PHEV, EV
    ICEV("ICEV"),
    HEV("HEV"),
    PHEV("PHEV"),
    EV("EV");

    private final String value;

    CarType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static CarType fromName(String name) {
        return EnumUtil.fromString(CarType.class, name);
    }
}
