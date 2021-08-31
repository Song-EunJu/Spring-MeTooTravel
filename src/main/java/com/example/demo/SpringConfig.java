package com.example.demo;

import com.example.demo.repository.JpaWritingRepository;
import com.example.demo.repository.MemoryWritingRepository;
import com.example.demo.repository.WritingRepository;
import com.example.demo.service.WritingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public WritingService writingService(){
        return new WritingService(writingRepository());
    }

    @Bean
    public WritingRepository writingRepository(){
//        return new MemoryWritingRepository();
        return new JpaWritingRepository(em);
    }

}
