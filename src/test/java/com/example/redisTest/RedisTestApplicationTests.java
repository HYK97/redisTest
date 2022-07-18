package com.example.redisTest;

import io.lettuce.core.RedisClient;
import io.lettuce.core.StatefulRedisConnectionImpl;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RedisTestApplicationTests {

	@Test
	@DisplayName("redis 접속 테스트")
	void loadTest() {
		RedisClient client = RedisClient.create("redis://@localhost:6379/0");
		StatefulRedisConnection<String,String> connection = client.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		syncCommands.set("key", "Hello, Redis!");
		String value = syncCommands.get("key");
		assertThat(value).isEqualTo("Hello, Redis!");
		connection.close();
		client.shutdown();
	}

}
