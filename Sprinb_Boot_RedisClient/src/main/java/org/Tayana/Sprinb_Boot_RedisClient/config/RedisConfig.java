package org.Tayana.Sprinb_Boot_RedisClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory connectionFactory() 
	//above one is configured as an environmental and Client configuration
	//JedisConnectionFactory class supports RedisStandaloneConfiguration class (in these we have port and hostname as variables)
	//used to connect with Redis cache 
	{
		RedisStandaloneConfiguration rsc=new RedisStandaloneConfiguration();
		//above class is used to connect one stand alone redis cache 
		rsc.setHostName("localhost");
		rsc.setPort(6379); //default port number 
		return new JedisConnectionFactory(rsc);
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate() //set or fetch the values from redis cache memory
	{
		RedisTemplate<String, Object> template=new RedisTemplate<String, Object>(); //<key,value>
		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(new StringRedisSerializer()); //here StringRedisSerializer is used to encode or decode the string key values
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer()); //if key is an object it can deserialize using JdkSerializationRedisSerializer
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
		
	}

}
