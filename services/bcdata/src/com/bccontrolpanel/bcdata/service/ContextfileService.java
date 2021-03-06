/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.bccontrolpanel.bcdata.*;

/**
 * Service object for domain model class Contextfile.
 * @see com.bccontrolpanel.bcdata.Contextfile
 */

public interface ContextfileService {
   /**
	 * Creates a new contextfile.
	 * 
	 * @param created
	 *            The information of the created contextfile.
	 * @return The created contextfile.
	 */
	public Contextfile create(Contextfile created);

	/**
	 * Deletes a contextfile.
	 * 
	 * @param contextfileId
	 *            The id of the deleted contextfile.
	 * @return The deleted contextfile.
	 * @throws EntityNotFoundException
	 *             if no contextfile is found with the given id.
	 */
	public Contextfile delete(ContextfileId contextfileId) throws EntityNotFoundException;

	/**
	 * Finds all contextfiles.
	 * 
	 * @return A list of contextfiles.
	 */
	public Page<Contextfile> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Contextfile> findAll(Pageable pageable);
	
	/**
	 * Finds contextfile by id.
	 * 
	 * @param id
	 *            The id of the wanted contextfile.
	 * @return The found contextfile. If no contextfile is found, this method returns
	 *         null.
	 */
	public Contextfile findById(ContextfileId id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a contextfile.
	 * 
	 * @param updated
	 *            The information of the updated contextfile.
	 * @return The updated contextfile.
	 * @throws EntityNotFoundException
	 *             if no contextfile is found with given id.
	 */
	public Contextfile update(Contextfile updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the contextfiles in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the contextfile.
	 */

	public long countAll();


    public Page<Contextfile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

