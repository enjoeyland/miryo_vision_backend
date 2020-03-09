package com.example.miryo_vision_backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<Response,CreatRequest,UpdateRequest,DeleteRequest,SearchRequest> {
    void create(CreatRequest request);
    default void createAll(List<CreatRequest> requestList){
        for (CreatRequest dto: requestList) {
            create(dto);
        }
    }
    void update(UpdateRequest request) throws Exception;
    default void updateAll(List<UpdateRequest> requestList) throws Exception {
        for (UpdateRequest dto: requestList) {
            update(dto);
        }
    }
    void delete(DeleteRequest request);
    default void deleteAll(List<DeleteRequest> requestList){
        for (DeleteRequest dto: requestList) {
            delete(dto);
        }
    }
    List<Response> search(SearchRequest request);
    List<Response> getAll();
}
