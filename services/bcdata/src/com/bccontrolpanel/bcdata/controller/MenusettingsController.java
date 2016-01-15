/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.bccontrolpanel.bcdata.service.MenusettingsService;
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
 * Controller object for domain model class Menusettings.
 * @see com.bccontrolpanel.bcdata.Menusettings
 */
@RestController(value = "Bcdata.MenusettingsController")
@RequestMapping("/bcdata/Menusettings")
@Api(description = "Exposes APIs to work with Menusettings resource.", value = "MenusettingsController")
public class MenusettingsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenusettingsController.class);

    @Autowired
    @Qualifier("bcdata.MenusettingsService")
    private MenusettingsService menusettingsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Menusettings instances matching the search criteria.")
    public Page<Menusettings> findMenusettingss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Menusettingss list");
        return menusettingsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Menusettings instances.")
    public Page<Menusettings> getMenusettingss(Pageable pageable) {
        LOGGER.debug("Rendering Menusettingss list");
        return menusettingsService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setMenusettingsService(MenusettingsService service) {
        this.menusettingsService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Menusettings instance.")
    public Menusettings createMenusettings(@RequestBody Menusettings instance) {
        LOGGER.debug("Create Menusettings with information: {}", instance);
        instance = menusettingsService.create(instance);
        LOGGER.debug("Created Menusettings with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Menusettings instances.")
    public Long countAllMenusettingss() {
        LOGGER.debug("counting Menusettingss");
        Long count = menusettingsService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Menusettings instance associated with the given id.")
    public Menusettings getMenusettings(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Menusettings with id: {}", id);
        Menusettings instance = menusettingsService.findById(id);
        LOGGER.debug("Menusettings details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Menusettings instance associated with the given id.")
    public Menusettings editMenusettings(@PathVariable("id") Integer id, @RequestBody Menusettings instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Menusettings with id: {}", instance.getId());
        instance.setId(id);
        instance = menusettingsService.update(instance);
        LOGGER.debug("Menusettings details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Menusettings instance associated with the given id.")
    public boolean deleteMenusettings(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Menusettings with id: {}", id);
        Menusettings deleted = menusettingsService.delete(id);
        return deleted != null;
    }
}
