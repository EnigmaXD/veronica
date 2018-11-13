package com.veronica.redis.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

public abstract class RedisPool {

    private static final Logger logger = LogManager.getLogger(RedisPool.class);

    private static LettuceConnectionFactory connectionFactory;

    public RedisPool(String ip, String port) {

    }

    public LettuceConnectionFactory getRedis() {
        if (null == connectionFactory) {
        }
        return connectionFactory;
    }

}
