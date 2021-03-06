package com.learnnew.spring.data.cassandra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.learnnew.spring.data.cassandra.model.Tutorial;
@Repository
public interface TutorialRepository extends CassandraRepository<Tutorial, UUID> {
  @AllowFiltering
  List<Tutorial> findByPublished(boolean published);
  
  List<Tutorial> findByTitleContaining(String title);
}
