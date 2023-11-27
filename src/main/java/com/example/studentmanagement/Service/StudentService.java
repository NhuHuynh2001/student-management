package com.example.studentmanagement.Service;

import com.example.studentmanagement.Model.Request.StudentRequest;
import com.example.studentmanagement.Model.Response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest studentManagementRequest);

    StudentResponse findById(Integer id) throws Exception;

    List<StudentResponse> findByAll();

    StudentResponse updateStudent(Integer id , StudentRequest studentRequest) throws Exception;



}
