package com.graphql.queries;

import com.graphql.schema.College;
import com.graphql.schema.Student;
import com.graphql.service.CollegeService;
import com.graphql.service.StudentService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollegeQuery {

  @Autowired CollegeService collegeService;

  @Autowired StudentService studentService;

  @GraphQLQuery(name = "getcollege")
  @GraphQLNonNull
  public College getCollegeById(@GraphQLNonNull @GraphQLArgument(name = "id") int id) {

    return collegeService.getCollegeById(id);
  }

  @GraphQLQuery(name = "students")
  public List<Student> getStudents(@GraphQLContext College college) {

    return studentService.getStudentsByCollegeId(college.getId());
  }
}
