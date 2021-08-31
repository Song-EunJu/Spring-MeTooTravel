//package com.example.demo.repository;
//
//import com.example.demo.domain.CommunityWriting;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Optional;
//
//public class JdbcTemplateWritingRepository implements WritingRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public CommunityWriting save(CommunityWriting cw) {
//        return null;
//    }
//
//    @Override
//    public Optional<CommunityWriting> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<CommunityWriting> findByTitle(String title) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<CommunityWriting> findByKeyword(String keyword) {
//        return null;
//    }
//
//    @Override
//    public Optional<CommunityWriting> findByEmail(String email) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<CommunityWriting> findPopular() {
//        return null;
//    }
//
//    @Override
//    public List<CommunityWriting> findAllWriting() {
//        return null;
//    }
//
//    private RowMapper<Member> memberRowMapper() {
//        return (rs, rowNum) -> {
//            Member member = new Member();
//            member.setId(rs.getLong("id"));
//            member.setName(rs.getString("name"));
//            return member;
//        };
//    }
//}
