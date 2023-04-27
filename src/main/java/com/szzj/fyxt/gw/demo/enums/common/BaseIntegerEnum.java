package com.szzj.fyxt.gw.demo.enums.common;

import com.fasterxml.jackson.annotation.JsonValue;


public interface BaseIntegerEnum {

    /**
     * 获取枚举值
     *
     * @return
     */
    Integer getValue();

    /**
     * 获取枚举文本
     *
     * @return
     */
    String getLabel();

    /**
     * 根据枚举值和type获取枚举
     */
    public static <T extends BaseIntegerEnum> T getEnum(Class<T> type, Integer value) {
        T[] objs = type.getEnumConstants();
        for (T em : objs) {
            if (em.getValue().equals(value)) {
                return em;
            }
        }
        return null;
    }


    @JsonValue
    default Integer getJsonValue() {
        return getValue();
    }
}
