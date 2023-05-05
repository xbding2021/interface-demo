package com.szzj.fyxt.gw.demo.utils;

import com.szzj.fyxt.gw.demo.config.StartConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestUtils {

    public static String sendRequest(String url, String content) {
        HttpUtil httpUtil = HttpUtil.getInstance();
        content = AESSymmtricEncrypt.encrypt(content, StartConfig.SECRET);
        //content = "62CV0gVfECb0g2jSLnEerOC7wDLPQJ5TkAK/bvP7naqjcVdbP3kSFRqjH8KR8XPCn/bEpeFa55w/4CjEtp3gTw==21`21`21`12`";
        System.out.println(content);
        Map<String, String> header = new HashMap<>();
        header.put("APP-ID", StartConfig.APP_ID);
        log.info("cherry-pick1");
        log.info("cherry-pick2");
        return httpUtil.sendHttpPostJson(url, content, header);
    }
}
