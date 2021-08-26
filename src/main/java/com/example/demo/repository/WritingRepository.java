package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;

import java.util.List;
import java.util.Optional;

public interface WritingRepository {
    CommunityWriting save(CommunityWriting cw); // 글 저장
    Optional<CommunityWriting> findByTitle(String title); // 글 제목으로 찾기
    List<CommunityWriting> findPopular();     // 인기글 5개만 불러오기
}
