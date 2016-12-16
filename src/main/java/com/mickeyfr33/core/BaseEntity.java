package com.mickeyfr33.core;

import javax.persistence.*;

/**
 * Created by michaelsmith on 12/14/16.
 * Copyright Acceptto Corporation.
 */

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
