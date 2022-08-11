package com.dhc.app.api.logic.common.model;

import javax.persistence.PreUpdate;
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
        model.setModified(now);
    }

}
