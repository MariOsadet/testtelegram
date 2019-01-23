package redis;

import ai.grakn.redisq.Queue;
import ai.grakn.redisq.RedisqBuilder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.Pool;

public class RedisConsumer {

    public void consum() {
        Pool<Jedis> jedisPool = new JedisPool();

        Queue<RedisObject> redisq = new RedisqBuilder<RedisObject>()
                .setJedisPool(jedisPool)
                .setName("user_file")
                .setConsumer((d) -> System.out.println("I'm consuming " + d.getFileId()))
                .setDocumentClass(RedisObject.class)
                .createRedisq();
        redisq.startConsumer();

        try {
            redisq.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
