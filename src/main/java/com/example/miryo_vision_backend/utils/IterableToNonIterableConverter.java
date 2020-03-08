package com.example.miryo_vision_backend.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring")
public class IterableToNonIterableConverter {
    @Named("getFirstElement")
    public <T> T getFirstElement( List<T> l ) {
        if ( l != null && !l.isEmpty() ) {
            return l.get( 0 );
        }
        else {
            return null;
        }
    }

    @Named("getLastElement")
    public <T> T getLastElement( List<T> l ) {
        if ( l != null && !l.isEmpty() ) {
            return l.get( l.size() - 1 );
        }
        else {
            return null;
        }
    }
}
