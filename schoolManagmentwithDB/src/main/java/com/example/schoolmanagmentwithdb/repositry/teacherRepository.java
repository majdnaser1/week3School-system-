package com.example.schoolmanagmentwithdb.repositry;

import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);
    List<Teacher> findTeacherBySalary(Integer id);



}
