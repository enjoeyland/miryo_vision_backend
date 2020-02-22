package com.example.miryo_vision_backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<T> {
    void create(T t);
    void createAll(List<T> tList);
    void update(T t);
    void updateAll(List<T> tList);
    void delete(T t);
    void deleteAll(List<T> tList);
    List<T> search(T t);
    List<T> getAll();
}
