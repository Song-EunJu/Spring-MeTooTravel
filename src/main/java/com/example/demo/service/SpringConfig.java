package com.example.demo.service;

import com.example.demo.repository.WritingRepository;
import com.example.demo.service.WritingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final WritingRepository writingRepository;

    public SpringConfig(WritingRepository writingRepository) {
        this.writingRepository = writingRepository;
    }

    @Bean
    public WritingService writingService(){
        return new WritingService(writingRepository);
    }
}
