package com.memory.client.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.memory.client.model.Picture;
import com.memory.client.model.User;
import com.memory.client.model.Words;
import com.memory.client.properties.MemoryClientProperties;
import com.memory.client.service.MemoryClientService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.memory.client.utils.SignUtils.getSign;

/**
 * @author 邓哈哈
 * 2024/1/8 11:03
 * Function:
 * Version 1.0
 */

public class MemoryClientServiceImpl implements MemoryClientService {
    @Resource
    private MemoryClientProperties memoryClientProperties;

    private String accessKey;
    private String secretKey;

    public MemoryClientServiceImpl() {
    }

    public MemoryClientServiceImpl(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * Gateway 网关地址
     */
    private static final String GATEWAY_HOST = "http://localhost:8090";

    /**
     * @param name 姓名
     */
    @Override
    public void getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
    }

    /**
     * @param name 姓名
     */
    @Override
    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
    }

    /**
     * 复读机
     *
     * @param user 用户名
     * @return 返回用户名
     */
    @Override
    public String getUserByPost(User user) {
        String json = JSONUtil.toJsonStr(user);

        return HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .body();
    }

    /**
     * 获取随机名言
     *
     * @param words 名言类型
     * @return 随机名言
     */
    @Override
    public String getRandomWord(Words words) {
        String json = JSONUtil.toJsonStr(words);
        return HttpRequest.post(GATEWAY_HOST + "/api/words/one/random")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .body();
    }

    /**
     * 获取随机壁纸
     *
     * @param picture 壁纸类型
     * @return 壁纸名言
     */
    @Override
    public String getPictureListByType(Picture picture) {
        String json = JSONUtil.toJsonStr(picture);
        return HttpRequest.post(GATEWAY_HOST + "/api/wallpaper/list/page/vo")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .body();
    }

    /**
     * 构建一个包含签名的头部信息映射
     *
     * @param body 请求体
     * @return 包含特定键值对的 HashMap
     */
    public Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();

        // 判断是否为登录用户发起测试调用
        if (accessKey == null && secretKey == null) {
            accessKey = memoryClientProperties.getAccessKey();
            secretKey = memoryClientProperties.getSecretKey();
        }

        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", getSign(body, secretKey));

        return hashMap;
    }
}
