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

    String getRandomWord(Words words);

    String getPictureListByType(Picture picture);
}
