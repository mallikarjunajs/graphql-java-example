package com.graphql.queries;

import com.graphql.schema.Student;
import com.graphql.service.StudentService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentQuery {

  @Autowired StudentService studentService;

  @GraphQLQuery(name = "getStudent")
  public Student getStudentById(@GraphQLNonNull @GraphQLArgument(name = "id") int id) {

    return studentService.getStudentById(id);
  }
}
