package com.example.schoolmanagmentwithdb.service;

import com.example.schoolmanagmentwithdb.dto.ApiException;
import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.model.Teacher;
import com.example.schoolmanagmentwithdb.repositry.studentRepository;
import com.example.schoolmanagmentwithdb.repositry.teacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class teacherService {
    private final teacherRepository teacherrepository;


    public List<Teacher> getTeacher(){
        return teacherrepository.findAll();
    }
    public void add_teacher(Teacher teacher){
        teacherrepository.save(teacher);

    }
    public void update_teacher(Teacher teacher, Integer id){
        Teacher new_teacher = teacherrepository.getById(id);
        new_teacher.setName(teacher.getName());
        new_teacher.setSalary(teacher.getSalary());
        teacherrepository.save(new_teacher);
    }
    public void delete_teacher(Integer id){
        Teacher myTeacher=teacherrepository.getById(id);
        teacherrepository.delete(myTeacher);
    }

    public Teacher findTeacherBYId(Integer id) {
        Teacher teacher = teacherrepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Wrong id");
        }
        return teacher;

    }

    public List<Teacher> findStudentBYSalary(Integer salary) {
        return teacherrepository.findTeacherBySalary(salary);



    }
}
