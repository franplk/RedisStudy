package cn.plk.redis;

import java.util.List;

/**
 * @author {康培亮/AB052634}
 *
 */
import redis.clients.jedis.Jedis;

public class StoreTest {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		jedis.auth("12345678");

		// 1.设置 redis 字符串数据,获取存储的数据并输出
		System.out.println("Connection to server sucessfully");
		jedis.set("Author", "Franplk");
		System.out.println("Stored string in redis:: " + jedis.get("Author"));

		// 2.存储数据到列表中
		jedis.lpush("tutorial-list-1", "Redis");
		jedis.lpush("tutorial-list-1", "Mongodb");
		jedis.lpush("tutorial-list-1", "Mysql");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("tutorial-list-1", 0, -1);
		for (String value : list) {
			System.out.println("Stored string in redis:: " + value);
		}
		
		// Close
		jedis.close();
	}
}