package redis;

import org.junit.Assert;
import org.junit.Test;

public class RedisObjectTest {

    @Test
    public void testConstructor() {
        final RedisObject redisObject = new RedisObject("Test", "0");
        Assert.assertEquals("0", redisObject.getIdAsString());
        Assert.assertEquals("Test", redisObject.getFileId());
    }

}
