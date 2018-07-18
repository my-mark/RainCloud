package test;

import com.youlanw.app.utils.RedisUtil;
import com.youlanw.common.utils.redis.RedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class RedisTest {

    @Test
    public void publisher_test(){
        RedisPoolUtil redisPoolUtil = new  RedisPoolUtil(null,"10.0.11.65","",6379,6);
        redisPoolUtil.ItemSet("notify", "新浪微博：小叶子一点也不逗");
//        redisPoolUtil.Expire("notify", 10);
        redisPoolUtil.delByKey("notify");
    }


}
