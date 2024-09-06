package org.egedede.ewordlist.spring;

import org.egedede.ewordlist.repository.WordListRepository;
import org.egedede.ewordlist.service.WordListService;
import org.egedede.ewordlist.service.WordListServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureApplication {
  @Bean
  WordListService createListService(WordListRepository repository) {
    return new WordListServiceImpl(repository);
  }
}
