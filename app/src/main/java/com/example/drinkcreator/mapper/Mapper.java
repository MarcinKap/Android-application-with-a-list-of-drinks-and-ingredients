package com.example.drinkcreator.mapper;

public interface Mapper<F, T> {

    T mapToEntity(F from);
    F mapFromEntity(T to);
}