package com.dhc.app.api.utils.service.impl;

import com.dhc.app.api.service.common.model.BaseModel;
import com.dhc.app.api.utils.JpaUtils;
import com.dhc.app.api.utils.repository.BaseRepository;
import com.dhc.app.api.utils.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public abstract class BaseServiceImpl<D extends BaseRepository<T, ID>, T extends BaseModel, ID> implements BaseService<T, ID> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected D dao;


    @Override
    public Optional<T> findById(ID id) {
        return dao.findById(id);
    }

    @Override
    public void save(T entity) {
        if (entity.getIsDeleted() == null) {
            entity.setIsDeleted(false);
        }

        dao.save(entity);
    }

    @Override
    public void updateById(T entity) {
        dao.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(ID id) {
        dao.findById(id)
                .ifPresent(entity -> {
                    entity.setIsDeleted(true);
                    dao.save(entity);
                });
    }

    @Override
    public Page<T> findAll(Integer page, Integer size, String sort, T condition) {
        // 将sort解析为Sort对象
        Sort sortObj = JpaUtils.parseSort(sort);

        // 构造分页对象
        Pageable pageable = PageRequest.of(page - 1, size, sortObj);

        // 构造查询条件，将isDeleted设置为0，表示未删除的数据
        condition.setIsDeleted(false);
        Example<T> example = Example.of(condition);
        return dao.findAll(example, pageable);
    }
}
