package com.graphql.service;

import com.graphql.schema.College;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

  public College getCollegeById(int id) {
    return new College(id, "Stanford");
  }
}
