package com.szzj.fyxt.gw.demo.enums.common;

import lombok.Data;


@Data
public class BaseIntegerEnumDTO {

    private Integer value;

    private Integer code;

    private String label;

    public BaseIntegerEnumDTO(BaseIntegerEnum baseEnum) {
        this.code = baseEnum.getValue();
        this.value = baseEnum.getValue();
        this.label = baseEnum.getLabel();
    }
}
