package org.Tayana.Sprinb_Boot_RedisClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SprinbBootRedisClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinbBootRedisClientApplication.class, args);
	}

}
