package com.example.schoolmanagmentwithdb.service;

import com.example.schoolmanagmentwithdb.dto.ApiException;
import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.repositry.studentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
@AllArgsConstructor
public class studentService {
    private final studentRepository studentrepository;


    public List<Student> getStudent(){
       return studentrepository.findAll();
    }
    public void add_student(Student student){
        studentrepository.save(student);

    }
    public void update_student(Student student, Integer id){
        Student new_student = studentrepository.getById(id);
        new_student.setName(student.getName());
        new_student.setAge(student.getAge());
        new_student.setMajor(student.getMajor());
        studentrepository.save(new_student);
    }
    public void delete_student(Integer id){
        Student myStudent=studentrepository.getById(id);
        studentrepository.delete(myStudent);
    }


    public List<Student> findStudentBYmajor(String major) {
      List<Student> student=studentrepository.findStudentByMajor(major);
        if (student == null) {
            throw new ApiException("Wrong major");
        }
        return student;

    }

    public Student findStudentBYId(Integer id) {
        Student students = studentrepository.findStudentById(id);
        if (students == null) {
            throw new ApiException("Wrong id");
        }
        return students;
    }


    public Student findStudentBYName(String name) {
        Student student = studentrepository.findStudentByName(name);
        if (student == null) {
            throw new ApiException("Wrong NAME");
        }
        return student;
    }

    public List<Student> findStudentBYAgeGreaterThan(Integer age) {
        return studentrepository.findStudentsByAgeGreaterThan(age);


    }
}
