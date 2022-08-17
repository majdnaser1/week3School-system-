package com.example.schoolmanagmentwithdb.repositry;

import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    List<Student> findStudentByMajor(String major);
    List<Student> findStudentsByAgeGreaterThan(Integer age);






}
