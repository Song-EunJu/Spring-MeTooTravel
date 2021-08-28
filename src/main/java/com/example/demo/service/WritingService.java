package com.example.demo.service;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.repository.WritingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public class WritingService {
    private final WritingRepository writingRepository;

    public WritingService(WritingRepository writingRepository) {
        this.writingRepository = writingRepository;
    }

    // 글 등록하기
    public Long createWriting(CommunityWriting cw){
        writingRepository.save(cw);
        return
    }

    // 글 등록하기기
   public Long join(Member member){
        validateDuplicateMember(member); // 중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }




    // 자신이 적은 모든 글 찾아오기
    public List<CommunityWriting> findAllMyWriting(String email){
        return writingRepository.findAllWriting().
                stream().filter(writing -> writing.getEmail().equals(email)).
                collect(Collectors.toList());
    }
}
