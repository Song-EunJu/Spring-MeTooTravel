package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
// 데이터베이스 커넥션 정보들과 application,properties 에서 설정했던 정보들을 짬뽕해서 스프링부트가 em을 만들어준다.
// jpa를 사용하려면 entity manager를 주입받아야 한다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
        // jpa가 insert query 만들어서 집어넣고 setid 까지 다해줌
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    /*@Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }
*/
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
        // jpql 이라는 언어 - 테이블 대상이 아니라 객체를 대상으로 쿼리를 날리는 것 (그럼 sql로 번역이 됨)
    }
}
