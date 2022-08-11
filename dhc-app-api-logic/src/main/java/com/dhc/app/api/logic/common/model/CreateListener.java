package com.dhc.app.api.logic.common.model;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreateListener {

    @PrePersist
    void preCreate(BaseModel model) {
        Date now = new Date();
        if (model.getCreated() == null) {
            model.setCreated(now);
        }
        if (model.getModified() == null) {
            model.setModified(now);
        }
        if (model.getEnable() == null) {
            model.setEnable(true);
        }
    }

}
