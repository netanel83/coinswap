package com.coinswap.service;

import com.coinswap.constant.CommonStatus;
import com.coinswap.constant.SysAdvertiseLocation;
import com.coinswap.dao.SysAdvertiseDao;
import com.coinswap.entity.SysAdvertise;
import com.coinswap.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAdvertiseService extends BaseService {
    @Autowired
    private SysAdvertiseDao sysAdvertiseDao;


    public List<SysAdvertise> findAllNormal(SysAdvertiseLocation sysAdvertiseLocation){
        return sysAdvertiseDao.findAllByStatusAndSysAdvertiseLocationOrderBySortAsc(CommonStatus.NORMAL,sysAdvertiseLocation);
    }
    public List<SysAdvertise> findAllNormal(SysAdvertiseLocation sysAdvertiseLocation,String lang){
        return sysAdvertiseDao.findAllByStatusAndSysAdvertiseLocationAndLangOrderBySortAsc(CommonStatus.NORMAL,sysAdvertiseLocation,lang);
    }

}
