package com.example.schoolmanagmentwithdb.controller;

import com.example.schoolmanagmentwithdb.dto.ApiResponse;
import com.example.schoolmanagmentwithdb.model.Student;
import com.example.schoolmanagmentwithdb.model.Teacher;
import com.example.schoolmanagmentwithdb.service.studentService;
import com.example.schoolmanagmentwithdb.service.teacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class teacherController {
    private final teacherService teacherservice;
    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<Teacher> teachers=teacherservice.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/byId")
    public ResponseEntity <Teacher> findTeacherBYId(@RequestParam Integer id) {
        Teacher teacher = teacherservice.findTeacherBYId(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/byname")
    public ResponseEntity <List<Teacher>> findTeacherBySalary(@RequestParam Integer salary){
        List<Teacher> teacher=teacherservice.findStudentBYSalary(salary);
        return ResponseEntity.status(200).body(teacher);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherservice.add_teacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("new teacher added!!",200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id){
        teacherservice.update_teacher(teacher,id);
        return ResponseEntity.status(200).body(new ApiResponse(" teacher updated!!",200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable Integer id){
        teacherservice.delete_teacher(id);
        return ResponseEntity.status(200).body(new ApiResponse(" teacher deleted!!",200));

    }
}

