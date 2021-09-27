package com.spring.project.controller;

import com.spring.project.domain.User;
import com.spring.project.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor //lombok을 통한 의존성 주입
@RequestMapping("/api")
public class ApiController {

    private final UserRepository userRepository;

    //회원 등록
    @PostMapping("/user")
    public String insert(User user){
        userRepository.save(user);
        return "추가 ok";

    }

    //회원 정보
    @GetMapping("/user/{id}")
    public User findUser(@PathVariable long id){
       return userRepository.findById(id);

    }

    //모든 회원 정보
    @GetMapping("/user")
    public List<User> allUser(){
        return userRepository.allUser();
    }

    //회원 삭제
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id){
        userRepository.delete(id);
        return "삭제 ok";
    }

    //회원 수정
    @PutMapping("/user/{id}")
    public String update(@PathVariable long id,@ModelAttribute User user){
        userRepository.update(id,user);
        return "수정 ok";
    }

    //테스트용
    @PostConstruct
    public void init(){
        userRepository.save(new User("김은비",23));
        userRepository.save(new User("홍길동",24));
        userRepository.save(new User("김은비2",25));
    }
}
