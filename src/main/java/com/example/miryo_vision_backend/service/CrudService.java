package com.example.miryo_vision_backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<Response,CreatRequest,UpdateRequest,DeleteRequest,SearchRequest> {
    void create(CreatRequest request);
    void createAll(List<CreatRequest> requestList);
    void update(UpdateRequest request);
    void updateAll(List<UpdateRequest> requestList);
    void delete(DeleteRequest request);
    void deleteAll(List<DeleteRequest> requestList);
    List<Response> search(SearchRequest request);
    List<Response> getAll();
}
