  package com.graphql.config;
  
  import com.graphql.queries.CollegeQuery;
  import com.graphql.queries.StudentQuery;
  import graphql.schema.GraphQLSchema;
  import io.leangen.graphql.GraphQLSchemaGenerator;
  import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
  import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
  import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  
  @Configuration
  public class GraphqlConfig {
  
    @Autowired StudentQuery studentQuery;
  
    @Autowired CollegeQuery collegeQuery;
  
    @Bean
    GraphQLSchema schema() {
  
      GraphQLSchemaGenerator schemaGenerator =
          new GraphQLSchemaGenerator()
              .withResolverBuilders(
                  // Resolve by annotations
                  new AnnotatedResolverBuilder(),
                  // Resolve public methods inside root package
                  new PublicResolverBuilder("com.graphql"));
  
      schemaGenerator = schemaGenerator.withOperationsFromSingleton(studentQuery)
          .withOperationsFromSingleton(collegeQuery);
      return schemaGenerator.withValueMapperFactory(new JacksonValueMapperFactory()).generate();
    }
  }
