package com.shaowen.pollAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaowen.pollAPI.domain.Poll;
import com.shaowen.pollAPI.service.PollService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@SpringBootApplication(scanBasePackages = {"com.shaowen.pollAPI"})
public class PollApiApplication {

  private static final Logger logger = LoggerFactory.getLogger(PollApiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(PollApiApplication.class, args);
  }

  // Manually set pollService
  @Bean
  public PollService pollService() {
    return new PollService();
  }

  @Bean
  @Profile("!test")
  CommandLineRunner runner(PollService pollService) {
    return args -> {
      // read JSON and load json
      ObjectMapper mapper = new ObjectMapper();
      TypeReference<List<Poll>> typeReference = new TypeReference<List<Poll>>() {
      };

      ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      Resource[] resources = resolver.getResources("classpath*:/polls.json");
      InputStream inputStream = resources[0].getInputStream();
      try {
        List<Poll> polls = mapper.readValue(inputStream, typeReference);
        pollService.save(polls);
        logger.info("Polls Saved!");
      } catch (IOException e) {
        logger.error("Unable to save polls: " + e.getMessage());
      }
    };
  }

}
