package com.example.demo.service;

import com.example.demo.domain.CommunityWriting;
import com.example.demo.repository.MemoryWritingRepository;
import com.example.demo.repository.WritingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
class WritingServiceIntegrationTest {
    
    @Autowired WritingService writingService;
    @Autowired WritingRepository writingRepository;

    // 글 등록하기
    @Test
    public void 글생성(){
        CommunityWriting cw1 = new CommunityWriting();
        cw1.setEmail("이메일1");
        cw1.setTitle("글 제목1");
        cw1.setContent("글 내용1");
        cw1.setCurrentTime(new Date(2017,10,22));
        cw1.setLike(1);
        cw1.setDelete(0);

        Long id = writingService.createWriting(cw1);

        CommunityWriting findWriting = writingService.findOne(id).get();
        Assertions.assertThat(cw1.getId()).isEqualTo(findWriting.getId());
    }

    @Test
    public void 내가적은모든글찾기(){
        CommunityWriting cw1 = new CommunityWriting();
        cw1.setEmail("이메일1");
        cw1.setTitle("글 제목1");
        cw1.setContent("글 내용1");
        cw1.setCurrentTime(new Date(2017,10,22));
        cw1.setLike(1);
        cw1.setDelete(0);
        writingRepository.save(cw1);

        CommunityWriting cw2 = new CommunityWriting();
        cw2.setEmail("이메일1");
        cw2.setTitle("글 제목2");
        cw2.setContent("글 내용2");
        cw2.setCurrentTime(new Date(2017,10,22));
        cw2.setLike(3);
        cw2.setDelete(0);
        writingRepository.save(cw2);

        CommunityWriting cw3 = new CommunityWriting();
        cw3.setEmail("이메일2");
        cw3.setTitle("글 제목3");
        cw3.setContent("글 내용3");
        cw3.setCurrentTime(new Date(2017,10,22));
        cw3.setLike(3);
        cw3.setDelete(0);
        writingRepository.save(cw3);

        List<CommunityWriting> writings = writingService.findAllMyWriting("이메일1");
        System.out.println("writings.size() = " + writings.size());

    }

}