package com.memory.clientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.memory.clientsdk.model.User;
import com.memory.clientsdk.model.Words;

import java.util.HashMap;
import java.util.Map;

import static com.memory.clientsdk.utils.SignUtils.getSign;

/**
 * @author 邓哈哈
 * 2023/7/28 22:57
 * Function:
 * Version 1.0
 */

public class MemoryClient {
    private String accessKey;
    private String secretKey;
    private static final String GATEWAY_HOST = "http://localhost:8090";

    public MemoryClient() {
    }

    public MemoryClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * @param name
     */
    public void getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
    }

    /**
     * @param name
     */
    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
    }

    public Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", getSign(body, secretKey));
        return hashMap;
    }

    /**
     * @param user
     */
    public String getUserByPost(User user) {
        String json = JSONUtil.toJsonStr(user);

        return HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .body();
    }

    /**
     *
     * @param words
     * @return
     */
    public String getRandomWord(Words words) {
        String json = JSONUtil.toJsonStr(words);
        return HttpRequest.post(GATEWAY_HOST + "/api/words/one/random")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .body();
    }
}
