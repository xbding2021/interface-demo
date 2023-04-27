package com.szzj.fyxt.gw.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.szzj.fyxt.gw.demo.config.StartConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GatewayUtils {

    public static String sendRequest(String url, String content) {
        HttpUtil httpUtil = HttpUtil.getInstance();
        content = bulidGxptJsonRequestBody(content);
        return httpUtil.sendHttpPostJson(url, content, getRequestHeaders());
    }

    /**
     * 共享平台限制，无法直接传输加密requestBody,需要额外组装成一个POJO对象
     *
     * @param content
     * @return
     */
    public static String bulidGxptJsonRequestBody(String content) {
        // requestBody加密成Base64字符串传输
        content = AESSymmtricEncrypt.encrypt(content, StartConfig.SECRET);
        PostContent postContent = new PostContent();
        postContent.setContent(content);
        content = JSONObject.toJSONString(postContent);
        return content;
    }

    /**
     * 组装请求头
     *
     * @return
     */
    public static Map<String, String> getRequestHeaders() {
        Map<String, String> params = new HashMap<>();
        setYqgkParams(params);
        return params;
    }

    /**
     * 组装防疫系统鉴权参数
     *
     * @param params
     */
    private static void setYqgkParams(Map<String, String> params) {
        // 防疫系统通过YQ-APP-ID 获取 对应的 YQ-APP-SECRET 通过解密 校验 YQ-APP-ID 的合法性
        params.put("YQ-APP-ID", StartConfig.APP_ID);
    }

    @Data
    static class PostContent {
        private String content;
    }
}
