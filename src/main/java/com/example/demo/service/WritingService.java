package com.example.demo.service;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.repository.WritingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WritingService {
    private final WritingRepository writingRepository;

    public WritingService(WritingRepository writingRepository) {
        this.writingRepository = writingRepository;
    }

    // 자신이 적은 모든 글 찾아오기
    public List<CommunityWriting> findAllMyWriting(String email){
        return writingRepository.findAllWriting().
                stream().filter(writing -> writing.getEmail().equals(email)).
                collect(Collectors.toList());
    }
}
