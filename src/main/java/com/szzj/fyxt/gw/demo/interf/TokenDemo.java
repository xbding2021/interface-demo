package com.szzj.fyxt.gw.demo.interf;

import ch.qos.logback.classic.Level;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.szzj.fyxt.gw.demo.config.StartConfig;
import com.szzj.fyxt.gw.demo.dto.AnalysisTokenReq;
import com.szzj.fyxt.gw.demo.utils.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 查询病例人员信息demo
 */
@Slf4j
public class TokenDemo {

    public static void main(String[] args) throws JsonProcessingException {
        LogUtils.setLogLevel(Level.INFO);

        getTokenInfo(false);
    }

    /**
     * @param isProd 是否正式环境
     * @throws JsonProcessingException
     */
    public static void getTokenInfo(boolean isProd) throws JsonProcessingException {
        if (isProd) {
            //替换正式url
            String url = "xxxxxxxxx";
            String response = GatewayUtils.sendRequest(url, buildTokenInfoRequestContent());
            log.info("return {}", response);


        } else {
            String url = "https://zfxyfwcs.ding.zj.gov.cn/jcgzt/third/common/analysis/token";
            //String url = "http://localhost:18080/third/common/analysis/token";
            String response = TestUtils.sendRequest(url, buildTokenInfoRequestContent());
            log.info("return {}", response);
            JSONObject json = JSON.parseObject(response);
            log.info(AESSymmtricEncrypt.decrypt(json.getString("data"), StartConfig.SECRET));

        }
    }

    private static String buildTokenInfoRequestContent() throws JsonProcessingException {
        AnalysisTokenReq request = new AnalysisTokenReq();
        //set查询参数
        request.setToken("c6971a00a9a44b9392c827ec682b64049fc3bf01");
        return JsonUtils.writeValueAsString(request);
    }

}
