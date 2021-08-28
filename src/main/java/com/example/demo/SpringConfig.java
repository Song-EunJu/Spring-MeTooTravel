package com.example.demo;

import com.example.demo.repository.MemoryWritingRepository;
import com.example.demo.repository.WritingRepository;
import com.example.demo.service.WritingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public WritingService writingService(){
        return new WritingService(writingRepository());
    }

    @Bean
    public WritingRepository writingRepository(){
        return new MemoryWritingRepository();
    }
}
