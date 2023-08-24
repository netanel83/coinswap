package com.coinswap.constant;

import com.coinswap.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Netanel Dadon
 * @description system ad slot
 */
@AllArgsConstructor
@Getter
public enum SysAdvertiseLocation implements BaseEnum {
    APP_SHUFFLING("app home page carousel"),
    PC_SHUFFLING("PC Home Carousel"),
    PC_CLASSIFICATION("pc classifieds");
    @Setter
    private String cnName;
    @Override
    @JsonValue
    public int getOrdinal(){
        return ordinal();
    }
}
