package com.szzj.fyxt.gw.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static String writeValueAsString(Object content) throws JsonProcessingException {
        return objectMapper.writeValueAsString(content);
    }
}
