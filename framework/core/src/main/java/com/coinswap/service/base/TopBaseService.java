package com.coinswap.service.base;

import com.coinswap.dao.base.BaseDao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class TopBaseService <E, D extends  BaseDao> {
    @Autowired
    protected EntityManager entityManager;
}
