package com.example.schoolmanagmentwithdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor @Data
@Entity
public class Student {
//    Student Class : ID , name , age , major ( all should not be empty ) ( major enum { CS , MATH , Engineer )
    @Id
    Integer id;
    @Column(columnDefinition ="varchar(4) not null")
    String name;
    @Column(columnDefinition ="varchar(4) not null")
    Integer age;
    @Column(columnDefinition ="varchar(20) check(major = 'CS' or major = 'Math' or major ='Engineer')")
    String major;

}
