package com.szzj.fyxt.gw.demo.enums.common;

import lombok.Data;


@Data
public class BaseEnumDTO {

    private String code;

    private String value;

    private String label;

    public BaseEnumDTO(BaseStringEnum baseEnum) {
        this.code = baseEnum.getValue();
        this.value = baseEnum.getValue();
        this.label = baseEnum.getLabel();
    }
}
