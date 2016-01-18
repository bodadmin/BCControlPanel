/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.bccontrolpanel.bcdata.service.ContextfileService;
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
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Contextfile.
 * @see com.bccontrolpanel.bcdata.Contextfile
 */
@RestController(value = "Bcdata.ContextfileController")
@RequestMapping("/bcdata/Contextfile")
@Api(description = "Exposes APIs to work with Contextfile resource.", value = "ContextfileController")
public class ContextfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextfileController.class);

    @Autowired
    @Qualifier("bcdata.ContextfileService")
    private ContextfileService contextfileService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Contextfile instances matching the search criteria.")
    public Page<Contextfile> findContextfiles(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Contextfiles list");
        return contextfileService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Contextfile instances.")
    public Page<Contextfile> getContextfiles(Pageable pageable) {
        LOGGER.debug("Rendering Contextfiles list");
        return contextfileService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setContextfileService(ContextfileService service) {
        this.contextfileService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Contextfile instance.")
    public Contextfile createContextfile(@RequestBody Contextfile instance) {
        LOGGER.debug("Create Contextfile with information: {}", instance);
        instance = contextfileService.create(instance);
        LOGGER.debug("Created Contextfile with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Contextfile instance associated with the given composite-id.")
    public Contextfile getContextfile(@RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName) throws EntityNotFoundException {
        ContextfileId temp = new ContextfileId();
        temp.setContextName(contextName);
        temp.setContextFileName(contextFileName);
        LOGGER.debug("Getting Contextfile with id: {}", temp);
        Contextfile instance = contextfileService.findById(temp);
        LOGGER.debug("Contextfile details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Contextfile instance associated with the given composite-id.")
    public Contextfile editContextfile(@RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName, @RequestBody Contextfile instance) throws EntityNotFoundException {
        ContextfileId temp = new ContextfileId();
        temp.setContextName(contextName);
        temp.setContextFileName(contextFileName);
        contextfileService.delete(temp);
        instance = contextfileService.create(instance);
        LOGGER.debug("Contextfile details with id is updated: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Contextfile instance associated with the given composite-id.")
    public boolean deleteContextfile(@RequestParam("contextName") String contextName, @RequestParam("contextFileName") String contextFileName) throws EntityNotFoundException {
        ContextfileId temp = new ContextfileId();
        temp.setContextName(contextName);
        temp.setContextFileName(contextFileName);
        LOGGER.debug("Deleting Contextfile with id: {}", temp);
        Contextfile deleted = contextfileService.delete(temp);
        return deleted != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Contextfile instances.")
    public Long countAllContextfiles() {
        LOGGER.debug("counting Contextfiles");
        Long count = contextfileService.countAll();
        return count;
    }
}
