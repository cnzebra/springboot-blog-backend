package com.mfx.blog.utils;

import com.mfx.blog.modal.entity.UserDO;

import java.util.concurrent.ConcurrentHashMap;

public class MfxCache {
    private static ConcurrentHashMap<String, UserDO> cache = new ConcurrentHashMap();

    public static void set(UserDO userDO) {
        cache.put(userDO.getToken(), userDO);
    }

    public static UserDO get() {
        String token = ServletUtils.getToken();
        if (token == null) {
            return null;
        }
        return cache.get(token);
    }

    public static void remove() {
        String token = ServletUtils.getToken();
        if (token != null) {
            cache.remove(token);
        }
    }
}
