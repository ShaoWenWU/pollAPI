package com.shaowen.pollAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.shaowen.pollAPI"})
public class PollApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PollService pollService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Poll>> typeReference = new TypeReference<List<Poll>>(){};

			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = resolver.getResources("classpath*:/polls.json");
			InputStream inputStream = resources[0].getInputStream();
			try {
				List<Poll> polls = mapper.readValue(inputStream,typeReference);
				pollService.save(polls);
				System.out.println("Polls Saved!");
			} catch (IOException e){
				System.out.println("Unable to save polls: " + e.getMessage());
			}
		};
	}

}
