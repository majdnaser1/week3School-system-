package com.example.schoolmanagmentwithdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Teacher {
//    Teacher Class : ID , name , salary ( all should not be empty)
    @Id
    Integer id;
    @Column(columnDefinition = "varchar(20)  unique not null")
    String name;
    @Column(columnDefinition = "varchar(20) not null")
    Integer salary;

}
