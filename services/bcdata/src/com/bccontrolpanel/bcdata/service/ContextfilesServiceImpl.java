/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.bccontrolpanel.bcdata.*;


/**
 * ServiceImpl object for domain model class Contextfiles.
 * @see com.bccontrolpanel.bcdata.Contextfiles
 */
@Service("bcdata.ContextfilesService")
public class ContextfilesServiceImpl implements ContextfilesService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ContextfilesServiceImpl.class);

    @Autowired
    @Qualifier("bcdata.ContextfilesDao")
    private WMGenericDao<Contextfiles, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Contextfiles, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "bcdataTransactionManager")
     public Page<Contextfiles> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "bcdataTransactionManager")
    @Override
    public Contextfiles create(Contextfiles contextfiles) {
        LOGGER.debug("Creating a new contextfiles with information: {}" , contextfiles);
        return this.wmGenericDao.create(contextfiles);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "bcdataTransactionManager")
    @Override
    public Contextfiles delete(Integer contextfilesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting contextfiles with id: {}" , contextfilesId);
        Contextfiles deleted = this.wmGenericDao.findById(contextfilesId);
        if (deleted == null) {
            LOGGER.debug("No contextfiles found with id: {}" , contextfilesId);
            throw new EntityNotFoundException(String.valueOf(contextfilesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Page<Contextfiles> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all contextfiless");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Page<Contextfiles> findAll(Pageable pageable) {
        LOGGER.debug("Finding all contextfiless");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Contextfiles findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding contextfiles by id: {}" , id);
        Contextfiles contextfiles=this.wmGenericDao.findById(id);
        if(contextfiles==null){
            LOGGER.debug("No contextfiles found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return contextfiles;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "bcdataTransactionManager")
    @Override
    public Contextfiles update(Contextfiles updated) throws EntityNotFoundException {
        LOGGER.debug("Updating contextfiles with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

