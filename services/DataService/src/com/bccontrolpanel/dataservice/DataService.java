/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.bccontrolpanel.dataservice.model.* ;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import java.io.*;

/**
 * This is a singleton class with all of its public methods exposed to the client via controller.
 * Their return values and parameters will be pas sed to the client or taken
 * from the client respectively.
 */
@ExposeToClient
public class DataService {
    
    public class Struct {
        String variable1;
        String variable2;
    }
    
    public Struct[] lol() {
        
        Struct[] result = new Struct[2];
        result[0].variable1 = "lol";
        result[0].variable2 = "hi";
        result[1].variable1 = "lol";
        result[1].variable2 = "hi";
        return result;
    }
    
}
