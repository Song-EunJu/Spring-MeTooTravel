package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;

import java.util.List;
import java.util.Optional;

public interface WritingRepository {
    CommunityWriting save(CommunityWriting cw); // 글 저장
    Optional<CommunityWriting> findById(Long id); // 해당 id를 찾았을 때 null인 경우 optional 로 감싸서 반환
    Optional<CommunityWriting> findByTitle(String title); // 글 제목으로 찾기 (글제목이 중복이 아니라고 가정)
    List<CommunityWriting> findByKeyword(String keyword); // 키워드가 들어간 글들 찾기
    Optional<CommunityWriting> findByEmail(String email); // 특정 이메일로 찾기
//    List<CommunityWriting> findPopular();     // 인기글 5개만 불러오기
//    List<CommunityWriting> findAllWriting();    // 커뮤니티 글 모두 불러오기
}
