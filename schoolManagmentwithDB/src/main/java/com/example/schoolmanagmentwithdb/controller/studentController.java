package com.example.schoolmanagmentwithdb.controller;

import com.example.schoolmanagmentwithdb.dto.ApiResponse;
import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class studentController {
    private final studentService studentservice;
    @GetMapping
    public ResponseEntity<List> getStudent(){
        List<Student> students=studentservice.getStudent();
        return ResponseEntity.status(200).body(students);
    }
//    List<Student> findStudentByMajor(String major);

    @GetMapping("/major")
    public ResponseEntity<List<Student>> getStudentBYmajor(@RequestParam String major){
        List<Student> students=studentservice.findStudentBYmajor(major);
        return ResponseEntity.status(200).body(students);
    }

//    Student findStudentById(Integer id);

    @GetMapping("/byId")
    public ResponseEntity<Student> findStudentBYId(@RequestParam Integer id){
    Student students=studentservice.findStudentBYId(id);
    return ResponseEntity.status(200).body(students);
}

//    Student findStudentByName(String name);
    @GetMapping("/byname")
    public ResponseEntity <Student> getStudentBYName(@RequestParam String name){
        Student students=studentservice.findStudentBYName(name);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/age")
    public ResponseEntity <List<Student>> getStudentBYName(@RequestParam Integer age){
        List<Student> students=studentservice.findStudentBYAgeGreaterThan(age);
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody @Valid Student student){
        studentservice.add_student(student);
        return ResponseEntity.status(200).body(new ApiResponse("new student added!!",200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody @Valid Student student, @PathVariable Integer id){
        studentservice.update_student(student,id);
        return ResponseEntity.status(200).body(new ApiResponse(" student updated!!",200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id){
        studentservice.delete_student(id);
        return ResponseEntity.status(200).body(new ApiResponse(" student deleted!!",200));

    }

}
