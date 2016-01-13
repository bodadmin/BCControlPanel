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
 * Service object for domain model class MenuSettings.
 * @see com.bccontrolpanel.bcdata.MenuSettings
 */

public interface MenuSettingsService {
   /**
	 * Creates a new menusettings.
	 * 
	 * @param created
	 *            The information of the created menusettings.
	 * @return The created menusettings.
	 */
	public MenuSettings create(MenuSettings created);

	/**
	 * Deletes a menusettings.
	 * 
	 * @param menusettingsId
	 *            The id of the deleted menusettings.
	 * @return The deleted menusettings.
	 * @throws EntityNotFoundException
	 *             if no menusettings is found with the given id.
	 */
	public MenuSettings delete(Integer menusettingsId) throws EntityNotFoundException;

	/**
	 * Finds all menusettingss.
	 * 
	 * @return A list of menusettingss.
	 */
	public Page<MenuSettings> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<MenuSettings> findAll(Pageable pageable);
	
	/**
	 * Finds menusettings by id.
	 * 
	 * @param id
	 *            The id of the wanted menusettings.
	 * @return The found menusettings. If no menusettings is found, this method returns
	 *         null.
	 */
	public MenuSettings findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a menusettings.
	 * 
	 * @param updated
	 *            The information of the updated menusettings.
	 * @return The updated menusettings.
	 * @throws EntityNotFoundException
	 *             if no menusettings is found with given id.
	 */
	public MenuSettings update(MenuSettings updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the menusettingss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the menusettings.
	 */

	public long countAll();


    public Page<MenuSettings> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

