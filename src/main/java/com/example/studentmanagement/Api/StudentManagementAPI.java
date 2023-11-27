package com.example.studentmanagement.Api;

import com.example.studentmanagement.Model.Request.StudentRequest;
import com.example.studentmanagement.Model.Response.Response;
import com.example.studentmanagement.Model.Response.StudentResponse;
import com.example.studentmanagement.Service.StudentService;
import com.example.studentmanagement.Utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.API_VERSION )
@RequiredArgsConstructor
public class StudentManagementAPI {

    private final StudentService studentService;

    @PostMapping(Constants.STUDENTS)
    StudentResponse createStudent(@RequestBody StudentRequest studentManagementRequest) {
        return studentService.createStudent(studentManagementRequest);
    }

    @GetMapping("/{id}")
    Response<StudentResponse> findById(@PathVariable Integer id) throws Exception {
        return new  Response<>(studentService.findById(id));
    }

    @GetMapping(Constants.STUDENTS)
    Response<List<StudentResponse>> getAll(){
        return new Response<>(studentService.findByAll());
    }

    @PutMapping("/{id}")
    Response<StudentResponse> updateStudent(@PathVariable Integer id , @RequestBody StudentRequest studentRequest) throws  Exception{
        return new Response<>(studentService.updateStudent(id , studentRequest));
    }
}
