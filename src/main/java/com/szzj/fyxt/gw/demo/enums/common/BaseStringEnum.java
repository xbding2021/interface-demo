package com.szzj.fyxt.gw.demo.enums.common;

import com.fasterxml.jackson.annotation.JsonValue;


public interface BaseStringEnum {

    /**
     * 获取枚举值
     *
     * @return
     */
    String getValue();

    /**
     * 获取枚举文本
     *
     * @return
     */
    String getLabel();

    /**
     * 根据枚举值和type获取枚举
     */
    public static <T extends BaseStringEnum> T getEnum(Class<T> type, String value) {
        T[] objs = type.getEnumConstants();
        for (T em : objs) {
            if (em.getValue().equals(value)) {
                return em;
            }
        }
        return null;
    }


    @JsonValue
    default String getJsonValue() {
        return getValue();
    }
}
