package bot;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisConnection {
    RedisClient redisClient;
    StatefulRedisConnection<String, String> redisConnection;
    RedisCommands<String, String> syncCommands;

    public void connect() {
        redisClient = RedisClient.create("redis://0.0.0.0:6379/0"); // Format: redis://ip:post/dbNumber
        redisConnection = redisClient.connect();
        syncCommands = this.redisConnection.sync();

        System.out.println("before:" + syncCommands.get("key"));

        syncCommands.get("key");
        syncCommands.set("key", "value2");

        System.out.println("after:" + syncCommands.get("key"));

        redisConnection.close();
        redisClient.shutdown();

    }


}
