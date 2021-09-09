package com.example.demo.repository;

import com.example.demo.domain.CommunityWriting;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

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
    public Optional<CommunityWriting> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store.get(id)가 null이어도 감쌀 수 있다.
    }

    @Override
    public Optional<CommunityWriting> findByTitle(String title) {
        return store.values().stream()
                .filter(writing -> writing.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<CommunityWriting> findByKeyword(String keyword) {
        return store.values().stream()
                .filter(writing -> writing.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<CommunityWriting> findByEmail(String email) {
        return store.values().stream()
                .filter(writing -> writing.getEmail().equals(email))
                .findAny();
    }

//    @Override
//    public List<CommunityWriting> findPopular() {
//        Map<Long,CommunityWriting> temp = new HashMap<>(store);
//
//        /*
//            일단 HashMap은 순서가 존재하지 않기 때문에 List에 먼저 담아야 한다.
//            하지만 우리는 <Key, Value> 쌍을 유지한 상태로 정렬을 하는 것을 원하기 때문에 Map.Entry라는 것을 이용한다.
//        */
//
//        List<Map.Entry<Long,CommunityWriting>> list = new LinkedList<>(temp.entrySet());
//
//        // 내림차순 정렬
//        list.sort(new Comparator<Map.Entry<Long, CommunityWriting>>() {
//            @Override
//            public int compare(Map.Entry<Long, CommunityWriting> o1, Map.Entry<Long, CommunityWriting> o2) {
//                return o2.getValue().getLike() - o1.getValue().getLike();
//            }
//        });
//
//        /*  다음과 같이 출력해보면 여기까지는 내림차순 정렬 잘 된 상태
//            for(Map.Entry<Long,CommunityWriting> entry : list){
//                System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue().getLike());
//            }
//        */
//
//        //https://kmj1107.tistory.com/entry/Java-List-%EA%B0%92%EC%9D%84-Map-%EC%97%90-%EB%84%A3%EA%B8%B0
//
//        Map<Long, CommunityWriting> topPopular = new LinkedHashMap<>(); // 그냥 hashmap 으로 하면 4,5,6,7,8 이 순서처럼 내림차순 정렬 x
//        int count=0;
//        for(Map.Entry<Long,CommunityWriting> entry : list){
//            Long key = entry.getKey();
//            CommunityWriting value = entry.getValue();
//            topPopular.put(key,value);
//            count++;
//            if(count==5)
//                break;
//        }
//        return new ArrayList<>(topPopular.values()); // 이 temp가 좋아요 내림차순 정렬된 5개가 담긴 map
//    }

//    @Override
//    public List<CommunityWriting> findAllWriting(){
//        return new ArrayList<>(store.values());
//    }

    public void clearStore(){
        store.clear();
    }
}

