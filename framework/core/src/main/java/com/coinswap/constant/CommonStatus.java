package com.coinswap.constant;

import com.coinswap.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum CommonStatus implements BaseEnum {
    NORMAL("normal"),
    ILLEGAL("illegal");

    @Setter
    private String cnName;
    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
