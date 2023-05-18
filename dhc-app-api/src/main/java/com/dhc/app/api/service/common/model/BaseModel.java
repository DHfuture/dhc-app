package com.dhc.app.api.service.common.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners({CreateListener.class, UpdateListener.class})
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean enable;

    private Date created;

    private Date modified;

    private String ip;

}
