package com.coinswap.converter;
import org.springframework.core.convert.converter.Converter;

public class OrdinalToEnumConverter<T extends Enum<T>> implements Converter<Integer, T> {

    private final Class<T> enumType;
    public OrdinalToEnumConverter(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public T convert(Integer source) {
        T[] enums = enumType.getEnumConstants();
        if (source < 0 || source >= enums.length) {
            throw new IllegalArgumentException("Invalid ordinal value " + source + " for enum " + enumType);
        }
        return enums[source];
    }
}
