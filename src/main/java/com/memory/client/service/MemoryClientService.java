package com.memory.client.service;

import com.memory.client.model.Picture;
import com.memory.client.model.User;
import com.memory.client.model.Words;
import org.springframework.stereotype.Service;

@Service
public interface MemoryClientService {
    void getNameByGet(String name);

    String getNameByPost(String name);

    String getUserByPost(User user);

    /**
     * 获取随机名言
     *
     * @param words 名言类型
     * @return 随机名言
     */
    String getRandomWord(Words words);

    /**
     * 获取随机壁纸
     *
     * @param picture 壁纸类型
     * @return 壁纸名言
     */
    String getPictureListByType(Picture picture);
}
