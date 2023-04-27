package com.szzj.fyxt.gw.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnalysisTokenReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "token")
    private String token;

}
