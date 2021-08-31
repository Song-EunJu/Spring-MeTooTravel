package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaWritingRepository implements WritingRepository{

    private final EntityManager em;

    public JpaWritingRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public CommunityWriting save(CommunityWriting cw) {
        em.persist(cw);
        return cw;
    }

    @Override
    public Optional<CommunityWriting> findById(Long id) {
        CommunityWriting cw = em.find(CommunityWriting.class, id);
        return Optional.ofNullable(cw);
    }

    @Override
    public Optional<CommunityWriting> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<CommunityWriting> findByKeyword(String keyword) {
        return null;
    }

    @Override
    public Optional<CommunityWriting> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<CommunityWriting> findPopular() {
        return null;
    }

    @Override
    public List<CommunityWriting> findAllWriting() {
        return em
    }
}
