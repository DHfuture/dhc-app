package com.dhc.app.api.service.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({CreateListener.class, UpdateListener.class})
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean enable;

    private Date created;

    private Date modified;

    private String ip;
}
