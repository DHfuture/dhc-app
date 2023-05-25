package com.dhc.app.api.utils.repository;

import com.dhc.app.api.service.common.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 实现逻辑删除功能
 *
 * @param <T> 具体的po模型
 */
//@NoRepositoryBean 不生成实体
@NoRepositoryBean
//忽略idea的警告，不加也行，波浪线烦人
@SuppressWarnings("NullableProblems")
public interface BaseRepository<T extends BaseModel, ID> extends JpaRepository<T, ID> {


    @Override
    @Query("select t from #{#entityName} t where t.id = ?1 and t.isDeleted = false")
    //只读事务 提高查询效率
    @Transactional(readOnly = true)
    Optional<T> findById(ID id);

    @Override
    @Query("select t from #{#entityName} t where t.isDeleted = false")
    @Transactional(readOnly = true)
    List<T> findAll();

    /**
     * 逻辑删除
     *
     * @param id
     */
    @Query("update #{#entityName} t set t.isDeleted = false where t.id = ?1")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void logicDeleteById(ID id);
}
