package com.coinswap.dao;

import com.coinswap.constant.CommonStatus;
import com.coinswap.constant.SysAdvertiseLocation;
import com.coinswap.entity.SysAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface SysAdvertiseDao extends JpaRepository<SysAdvertise,String>, JpaSpecificationExecutor<SysAdvertise>, QuerydslPredicateExecutor<SysAdvertise> {

    List<SysAdvertise> findAllByStatusAndSysAdvertiseLocationOrderBySortAsc(CommonStatus status, SysAdvertiseLocation sysAdvertiseLocation);
    List<SysAdvertise> findAllByStatusAndSysAdvertiseLocationAndLangOrderBySortAsc(CommonStatus status, SysAdvertiseLocation sysAdvertiseLocation,String land);

}
