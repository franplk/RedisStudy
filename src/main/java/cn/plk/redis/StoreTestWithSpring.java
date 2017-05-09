package cn.plk.redis;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author {康培亮/AB052634}
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/context.xml")
public class StoreTestWithSpring extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void test() {
		Set<String> keys = redisTemplate.keys("*");
		//redisTemplate.
		ValueOperations<String, Object> value = redisTemplate.opsForValue();
		for(String key : keys){
			System.out.println(key + "=" + value.get(key));
		}
	}
}