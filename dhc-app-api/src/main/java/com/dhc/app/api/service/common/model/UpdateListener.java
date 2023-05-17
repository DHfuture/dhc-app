package com.dhc.app.api.service.common.model;

import jakarta.persistence.PreUpdate;

import java.util.Date;

/**
 * 更新前执行
 */
public class UpdateListener {

    /**
     * 更新前执行
     */
    @PreUpdate
    void preUpdate(BaseModel model) {
        Date now = new Date();
        model.setCreated(null);
        model.setModified(now);
    }

}
