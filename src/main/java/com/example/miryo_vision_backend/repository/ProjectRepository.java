package com.example.miryo_vision_backend.repository;

import com.example.miryo_vision_backend.entity.Project;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Long>, QuerydslPredicateExecutor<Project> {
    @Override
    @EntityGraph(value = "joinCustomerCompany", type = EntityGraph.EntityGraphType.LOAD)
    List<Project> findAll(Predicate predicate);



}
