/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.bccontrolpanel.bcdata.service.ContextparameterService;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;

import com.bccontrolpanel.bcdata.*;
import com.bccontrolpanel.bcdata.service.*;


/**
 * Controller object for domain model class Contextparameter.
 * @see com.bccontrolpanel.bcdata.Contextparameter
 */

@RestController(value = "Bcdata.ContextparameterController")
@Api(value = "/bcdata/Contextparameter", description = "Exposes APIs to work with Contextparameter resource.")
@RequestMapping("/bcdata/Contextparameter")
public class ContextparameterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextparameterController.class);

	@Autowired
	@Qualifier("bcdata.ContextparameterService")
	private ContextparameterService contextparameterService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Contextparameter instances matching the search criteria.")
	public Page<Contextparameter> findContextparameters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Contextparameters list");
		return contextparameterService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Contextparameter instances.")
	public Page<Contextparameter> getContextparameters(Pageable pageable) {
		LOGGER.debug("Rendering Contextparameters list");
		return contextparameterService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Contextparameter instances.")
	public Long countAllContextparameters() {
		LOGGER.debug("counting Contextparameters");
		Long count = contextparameterService.countAll();
		return count;
	}

	@RequestMapping(value = "/composite-id", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the Contextparameter instance associated with the given composite-id.")
	public Contextparameter getContextparameter( @RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName, @RequestParam("parameter") String parameter)
	 throws EntityNotFoundException {
	    ContextparameterId temp = new ContextparameterId();
	    temp.setContextName(contextName);
	    temp.setContextFileName(contextFileName);
	    temp.setParameter(parameter);
		LOGGER.debug("Getting Contextparameter with id: {}" , temp);
		Contextparameter instance = contextparameterService.findById(temp);
		LOGGER.debug("Contextparameter details with id: {}" , instance);
		return instance;
	}
	@RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deletes the Contextparameter instance associated with the given composite-id.")
	public boolean deleteContextparameter( @RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName, @RequestParam("parameter") String parameter)throws EntityNotFoundException {
	    ContextparameterId temp = new ContextparameterId();
        temp.setContextName(contextName);
        temp.setContextFileName(contextFileName);
        temp.setParameter(parameter);
		LOGGER.debug("Deleting Contextparameter with id: {}" , temp);
		Contextparameter deleted = contextparameterService.delete(temp);
		return deleted != null;
	}

	@RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates the Contextparameter instance associated with the given composite-id.")
	public Contextparameter editContextparameter( @RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName, @RequestParam("parameter") String parameter, @RequestBody Contextparameter instance) throws EntityNotFoundException {
	    ContextparameterId temp = new ContextparameterId();
         temp.setContextName(contextName);
         temp.setContextFileName(contextFileName);
         temp.setParameter(parameter);
        contextparameterService.delete(temp);
        instance = contextparameterService.create(instance);
	    LOGGER.debug("Contextparameter details with id is updated: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Contextparameter instance.")
	public Contextparameter createContextparameter(@RequestBody Contextparameter instance) {
		LOGGER.debug("Create Contextparameter with information: {}" , instance);
		instance = contextparameterService.create(instance);
		LOGGER.debug("Created Contextparameter with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setContextparameterService(ContextparameterService service) {
		this.contextparameterService = service;
	}
}
