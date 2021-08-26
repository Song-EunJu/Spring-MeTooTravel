package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryWritingRepositoryTest {
    MemoryWritingRepository repository = new MemoryWritingRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        CommunityWriting cw1 = new CommunityWriting();
        cw1.setEmail("이메일1");
        cw1.setTitle("글 제목1");
        cw1.setContent("글 내용1");
        cw1.setCurrentTime(new Date(2017,10,22));
        cw1.setLike(1);
        cw1.setDelete(0);

        repository.save(cw1);
        CommunityWriting result = repository.findByTitle(cw1.getTitle()).get();
        Assertions.assertEquals(cw1, result);
        assertThat(cw1).isEqualTo(result);
    }

    @Test
    public void findPopular(){
        CommunityWriting cw1 = new CommunityWriting();
        cw1.setEmail("이메일1");
        cw1.setTitle("글 제목1");
        cw1.setContent("글 내용1");
        cw1.setCurrentTime(new Date(2017,10,22));
        cw1.setLike(1);
        cw1.setDelete(0);
        repository.save(cw1);

        CommunityWriting cw2 = new CommunityWriting();
        cw2.setEmail("이메일2");
        cw2.setTitle("글 제목2");
        cw2.setContent("글 내용2");
        cw2.setCurrentTime(new Date(2017,10,22));
        cw2.setLike(2);
        cw2.setDelete(0);
        repository.save(cw2);

        CommunityWriting cw3 = new CommunityWriting();
        cw3.setEmail("이메일3");
        cw3.setTitle("글 제목3");
        cw3.setContent("글 내용3");
        cw3.setCurrentTime(new Date(2017,10,22));
        cw3.setLike(3);
        cw3.setDelete(0);
        repository.save(cw3);

        CommunityWriting cw4 = new CommunityWriting();
        cw4.setEmail("이메일4");
        cw4.setTitle("글 제목4");
        cw4.setContent("글 내용4");
        cw4.setCurrentTime(new Date(2017,10,22));
        cw4.setLike(4);
        cw4.setDelete(0);
        repository.save(cw4);

        CommunityWriting cw5 = new CommunityWriting();
        cw5.setEmail("이메일5");
        cw5.setTitle("글 제목5");
        cw5.setContent("글 내용5");
        cw5.setCurrentTime(new Date(2017,10,22));
        cw5.setLike(5);
        cw5.setDelete(0);
        repository.save(cw5);

        CommunityWriting cw6 = new CommunityWriting();
        cw6.setEmail("이메일6");
        cw6.setTitle("글 제목6");
        cw6.setContent("글 내용6");
        cw6.setCurrentTime(new Date(2017,10,22));
        cw6.setLike(6);
        cw6.setDelete(0);
        repository.save(cw6);

        CommunityWriting cw7 = new CommunityWriting();
        cw7.setEmail("이메일7");
        cw7.setTitle("글 제목7");
        cw7.setContent("글 내용7");
        cw7.setCurrentTime(new Date(2017,10,22));
        cw7.setLike(7);
        cw7.setDelete(0);
        repository.save(cw7);

        CommunityWriting cw8 = new CommunityWriting();
        cw8.setEmail("이메일8");
        cw8.setTitle("글 제목8");
        cw8.setContent("글 내용8");
        cw8.setCurrentTime(new Date(2017,10,22));
        cw8.setLike(8);
        cw8.setDelete(0);
        repository.save(cw8);

        List<CommunityWriting> result = repository.findPopular();
        for(CommunityWriting cw : result){
            System.out.println("cw.getLike() = " + cw.getLike());
        }
    }
}
