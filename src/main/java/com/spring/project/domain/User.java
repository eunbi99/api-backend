package com.spring.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;

    public User(){
    }

    public User(String name,int age){
        this.name=name;
        this.age=age;
    }

}
