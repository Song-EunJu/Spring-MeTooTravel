package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;

import java.util.*;

public class MemoryWritingRepository implements WritingRepository{
    private static Map<Long, CommunityWriting> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public CommunityWriting save(CommunityWriting cw) {
        cw.setId(++sequence);
        store.put(cw.getId(),cw);
        return cw;
    }

    @Override
    public Optional<CommunityWriting> findByTitle(String title) {
        return store.values().stream()
                .filter(writing -> writing.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<CommunityWriting> findPopular() {
        Map<Long,CommunityWriting> temp = new HashMap<>(store);
        List<Map.Entry<Long,CommunityWriting>> list = new ArrayList<>(temp.entrySet());
        list.sort(new Comparator<Map.Entry<Long, CommunityWriting>>() {
            @Override
            public int compare(Map.Entry<Long, CommunityWriting> o1, Map.Entry<Long, CommunityWriting> o2) {
                return o2.getValue().getLike() - o1.getValue().getLike();
            }
        }); // list에서 좋아요순으로 내림차순 정렬

//        return new ArrayList<>(store.values());

    }
}

