package com.example.demo.service;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.repository.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public class WritingService {
    private final WritingRepository writingRepository;

    public WritingService(WritingRepository writingRepository) {
        this.writingRepository = writingRepository;
    }

    // 글 등록하기
    public Long createWriting(CommunityWriting cw){
        writingRepository.save(cw);
        return cw.getId();
    }

    // 모든 글 불러오기
    public List<CommunityWriting> findAllWritings(){
        return writingRepository.findAllWriting();
    }

    /**
     * 특정 회원 조회 (아이디번호)
     */
    public Optional<CommunityWriting> findOne(Long memberId){
        return writingRepository.findById(memberId);
    }

    // 자신이 적은 모든 글 찾아오기
    public List<CommunityWriting> findAllMyWriting(String email){
        return writingRepository.findAllWriting().
                stream().filter(writing -> writing.getEmail().equals(email)).
                collect(Collectors.toList());
    }
}
