package com.graphql.service;

import com.graphql.schema.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

  public Student getStudentById(int id) {
    return new Student(id, "Rob");
  }

  public List<Student> getStudentsByCollegeId(int id) {
    return Arrays.asList(new Student(1, "Rob"), new Student(2, "Mark"));
  }
}
