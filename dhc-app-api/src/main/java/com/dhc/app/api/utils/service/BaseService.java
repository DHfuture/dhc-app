package com.dhc.app.api.utils.service;

import com.dhc.app.api.service.common.model.BaseModel;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BaseService<T extends BaseModel, ID> {


    Optional<T> findById(ID id);

    void save(T entity);

    void updateById(T entity);

    void deleteById(ID id);

    Page<T> findAll(Integer page, Integer size, String sort, T condition);
}
