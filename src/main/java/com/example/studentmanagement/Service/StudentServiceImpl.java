package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Exception.BadRequestException;
import com.example.studentmanagement.Exception.ResponseException;
import com.example.studentmanagement.Mapper.StudentMapper;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Model.Request.StudentRequest;
import com.example.studentmanagement.Model.Response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    private final StudentRepository studentManagementRepository;


    @Override
    public StudentResponse createStudent(StudentRequest studentManagementRequest) {
        StudentEntity studentManagementEntity = studentMapper.toEntity(studentManagementRequest);
        return studentMapper.toResponse(studentManagementRepository.save(studentManagementEntity));
    }

    @Override
    public StudentResponse findById(Integer id) throws Exception {
        Optional<StudentEntity> studentEntityOptional = studentManagementRepository.findById(id);
        if (studentEntityOptional.isEmpty()){
            throw  new ResponseException(BadRequestException.STUDENT_NOT_FOUND.getMessage() , BadRequestException.STUDENT_NOT_FOUND.getErrorCode());

        }
        StudentEntity studentEntity = studentEntityOptional.get();
        StudentResponse student = studentMapper.toResponse(studentEntity);

        return student;
    }

    @Override
    public List<StudentResponse> findByAll() {
        List<StudentEntity> studentEntity =  studentManagementRepository.findAll();
        List<StudentResponse> studentResponse = studentMapper.toResponses(studentEntity);
        return studentResponse;
    }

    @Override
    public StudentResponse updateStudent(Integer id , StudentRequest studentRequest) throws Exception {
        Optional<StudentEntity> studentEntityOptional = studentManagementRepository.findById(id);
        if (studentEntityOptional.isEmpty()){
            throw new ResponseException(BadRequestException.STUDENT_NOT_FOUND.getMessage() , BadRequestException.STUDENT_NOT_FOUND.getErrorCode());
        }
        StudentEntity updateStudentEntity = studentEntityOptional.get();
        updateStudentEntity.setName(studentRequest.getName());
        updateStudentEntity.setGender(studentRequest.getGender());
        updateStudentEntity.setClassRoom(studentRequest.getClassRoom());
        studentManagementRepository.save(updateStudentEntity);
        return studentMapper.toResponse(updateStudentEntity);
    }
}
