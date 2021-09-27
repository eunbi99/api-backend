package com.spring.project.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static final Map<Long,User> store = new HashMap<>();
    private static long sequence =0L; //순번

    //회원 등록
    public User save(User user){
        user.setId(++sequence);  // 유저의 id를 1씩 증가해서 set
        store.put(user.getId(),user);
        return user;
    }

    //아이디 찾기
    public User findById(Long id){
        return store.get(id);

    }

    //회원 모두 보기
    public List<User> allUser(){
        return new ArrayList<>(store.values());
    }

    //회원수정
    public void update(Long id,User updateParam){
        User findId = findById(id);
        findId.setName(updateParam.getName());
        findId.setAge(updateParam.getAge());

    }

    //회원 삭제
    public void delete(Long id){
        store.remove(id);
    }



}
