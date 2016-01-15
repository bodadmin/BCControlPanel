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
 * ServiceImpl object for domain model class Role.
 * @see com.bccontrolpanel.bcdata.Role
 */
@Service("bcdata.RoleService")
public class RoleServiceImpl implements RoleService {


    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    @Qualifier("bcdata.RoleDao")
    private WMGenericDao<Role, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Role, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "bcdataTransactionManager")
     public Page<Role> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "bcdataTransactionManager")
    @Override
    public Role create(Role role) {
        LOGGER.debug("Creating a new role with information: {}" , role);
        return this.wmGenericDao.create(role);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "bcdataTransactionManager")
    @Override
    public Role delete(Integer roleId) throws EntityNotFoundException {
        LOGGER.debug("Deleting role with id: {}" , roleId);
        Role deleted = this.wmGenericDao.findById(roleId);
        if (deleted == null) {
            LOGGER.debug("No role found with id: {}" , roleId);
            throw new EntityNotFoundException(String.valueOf(roleId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Page<Role> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all roles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Page<Role> findAll(Pageable pageable) {
        LOGGER.debug("Finding all roles");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "bcdataTransactionManager")
    @Override
    public Role findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding role by id: {}" , id);
        Role role=this.wmGenericDao.findById(id);
        if(role==null){
            LOGGER.debug("No role found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return role;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "bcdataTransactionManager")
    @Override
    public Role update(Role updated) throws EntityNotFoundException {
        LOGGER.debug("Updating role with information: {}" , updated);
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


