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
        List<CommunityWriting> result = em.createQuery("select m from CommunityWriting m where m.title = :title", CommunityWriting.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<CommunityWriting> findByKeyword(String keyword) {
        return null;
    }

    @Override
    public Optional<CommunityWriting> findByEmail(String email) {
        List<CommunityWriting> result = em.createQuery("select m from CommunityWriting m where m.title = :title", CommunityWriting.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().
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
