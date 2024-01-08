package com.memory.client.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 *
 * @author 邓哈哈
 */
public class SignUtils {
    /**
     * 生成签名
     *
     * @param body 请求体
     * @param secretKey 私钥
     * @return 签名
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;

        // 使用 SHA256 摘要算法生成签名
        return md5.digestHex(content);
    }
}
