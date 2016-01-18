package com.bccontrolpanel.bcdata.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.bccontrolpanel.bcdata.service.BcdataQueryExecutorService;
import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController(value = "Bcdata.QueryExecutionController")
@RequestMapping("/bcdata/queryExecutor")
@Api(description = "Controller class for query execution", value = "QueryExecutionController")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private BcdataQueryExecutorService queryService;

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/QueryArchiveDir", method = RequestMethod.GET)
    public Page<Object> executeQueryArchiveDir(@RequestParam(value = "qParam1", required = false) java.lang.String qParam1, @RequestParam(value = "qParam2", required = false) java.lang.String qParam2, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query QueryArchiveDir");
        Page<Object> result = queryService.executeQueryArchiveDir(pageable, qParam1, qParam2);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/wm_custom", method = RequestMethod.POST)
    @ApiOperation(value = "Process request to execute customer queries")
    public Page<Object> executeWMCustomQuery(@RequestBody CustomQuery query, Pageable pageable) {
        Page<Object> result = queryService.executeWMCustomQuerySelect(query, pageable);
        LOGGER.debug("got the result {}" + result);
        return result;
    }

    @RequestMapping(value = "/queries/wm_custom_update", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public int executeWMCustomQuery(@RequestBody CustomQuery query) {
        int result = queryService.executeWMCustomQueryUpdate(query);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}
