package redis;

import ai.grakn.redisq.Redisq;
import ai.grakn.redisq.RedisqBuilder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.Pool;

import java.util.Queue;

public class RedisProducer {

    public void produce(String fileId) throws InterruptedException {
        Pool<Jedis> pool = new JedisPool("0.0.0.0", 6379);
        Redisq<RedisObject> my_queue = new RedisqBuilder<RedisObject>()
                .setJedisPool(pool)
                .setName("user_file")
                .setDocumentClass(RedisObject.class)
                .createRedisq();

        my_queue.push(new RedisObject(fileId, "1"));


    }
}
