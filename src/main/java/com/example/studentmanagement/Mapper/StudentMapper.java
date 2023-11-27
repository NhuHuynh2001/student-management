package com.example.studentmanagement.Mapper;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Model.Request.StudentRequest;
import com.example.studentmanagement.Model.Response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentEntity toEntity (StudentRequest studentManagementRequest){
        StudentEntity studentManagementEntity = modelMapper.map(studentManagementRequest , StudentEntity.class);
        return  studentManagementEntity;
    }

    public StudentResponse toResponse(StudentEntity studentManagementEntity){
        StudentResponse studentManagementResponse = modelMapper.map(studentManagementEntity , StudentResponse.class);
        return studentManagementResponse;
    }
 
    public  List<StudentResponse> toResponses(List<StudentEntity> studentEntities){
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (StudentEntity entity: studentEntities) {
            studentResponses.add(this.toResponse(entity));
        }
        return studentResponses;


    }





}
