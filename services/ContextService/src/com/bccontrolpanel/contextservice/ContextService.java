/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.contextservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bccontrolpanel.bcdata.service.*;
import com.bccontrolpanel.bcdata.Contextfilename;
import java.util.*;

//import com.bccontrolpanel.contextservice.model.*;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;
import com.wavemaker.runtime.data.expression.AttributeType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.expression.Type;
/**
 * This is a singleton class with all of its public methods exposed to the client via controller.
 * Their return values and parameters will be passed to the client or taken
 * from the client respectively.
 */
@ExposeToClient
public class ContextService {

    private static final Logger logger=LoggerFactory.getLogger(ContextService.class);

    @Autowired
    public ContextfilenameService contxtfilenameService;
    //public Contextfilename contxtfilename;

    public long countContextFiles() {
        long count = contxtfilenameService.countAll();
        return count;
    }
    
    public String[] listContextFiles() {
        PageRequest page = new PageRequest(0, ((int) countContextFiles())); 
        Page<Contextfilename> contextFiles = contxtfilenameService.findAll(page);
        List<Contextfilename> contextFilesList = contextFiles.getContent();
        
        String[] result = new String[contextFilesList.size()];
        for (int i = 0; i < contextFilesList.size(); i++) {
            //result[i] = contextFilesList.get(i).get
            String contextFilename = contextFilesList.get(i).getFilename();
            String contextEnviroment = contextFilesList.get(i).getEnvironment();
            
            result[i] = contextFilename + " - " + contextEnviroment; 
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
