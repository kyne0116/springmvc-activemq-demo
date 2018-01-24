package com.simbest.jms.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishuyi
 */
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String sendTopic() throws Exception {
        String url = "http://localhost:7070/MQWriter/sendSampleTopic";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        String result = response.body().string();
        log.debug("请求调用完毕!，url:'{}'，result:'{}'", url, result);
        return "success";
    }


}
