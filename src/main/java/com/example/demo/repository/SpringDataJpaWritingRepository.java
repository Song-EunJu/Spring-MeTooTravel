package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaWritingRepository extends JpaRepository<CommunityWriting, Long>, WritingRepository {
    @Override
    List<CommunityWriting> findByKeyword(String keyword);

    @Override
    Optional<CommunityWriting> findByEmail(String email);

    @Override
    Optional<CommunityWriting> findByTitle(String title);

    @Override
    List<CommunityWriting> findPopular();
}
