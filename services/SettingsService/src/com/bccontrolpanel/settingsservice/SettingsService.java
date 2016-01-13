/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance 
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/   

package com.bccontrolpanel.settingsservice; 

import com.wavemaker.runtime.WMAppContext;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.manager.FileServiceManager;
import com.wavemaker.runtime.util.WMRuntimeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import java.io.*;

import com.wavemaker.runtime.service.annotations.ExposeToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a singleton class with all of its public methods exposed to the client via controller.
 * Their return values and parameters will be passed to the client or taken  
 * from the client respectively.
 * 
 */
@ExposeToClient
public class SettingsService {
    

    private static final Logger logger=LoggerFactory.getLogger(SettingsService.class);
    
    @Autowired
    private FileServiceManager fileServiceManager;

    private File uploadDirectory = null;

    @PostConstruct
    protected void init() {
        uploadDirectory = getUploadDir(); 
    }
    
    protected File getUploadDir() {
        String uploadDir = WMAppContext.getInstance().getContext().getRealPath("/resources/uploads");
        File f = new File(uploadDir);
        f.mkdirs();
        return f; 
    }
    
    public int countFiles(String relativePath) throws IOException { 
        MimetypesFileTypeMap m = new MimetypesFileTypeMap();
        File[] files = fileServiceManager.listFiles(relativePath == null ? uploadDirectory : new File(uploadDirectory, relativePath)); 


        int result = files.length;
        return result;
    }
    
    public String[] listFiles(String relativePath) throws IOException {
        MimetypesFileTypeMap m = new MimetypesFileTypeMap();
        File[] files = fileServiceManager.listFiles(relativePath == null ? uploadDirectory : new File(uploadDirectory, relativePath));
        
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) { 
            result[i] = files[i].getName();  
        }
        return result;
        
    }
    
    public static void writeToFile(String filename, String contents) throws IOException {
        
        String basedir = WMAppContext.getInstance().getContext().getRealPath("/resources/uploads");  
        String filepath = basedir + "/" + filename;
        String encoding = "utf-8";
        File file = new File(filepath);
        
        File parentDir = file.getParentFile();
        if(!parentDir.exists()){
            if(!parentDir.mkdirs()){
                throw new IOException("Could not create directory: " + parentDir.getAbsolutePath());
            }
        }

        OutputStream outStream = new FileOutputStream(file);
 
        BufferedWriter output = new java.io.BufferedWriter(new OutputStreamWriter(outStream, encoding));
        try {
            output.append(contents);
        } finally {
            output.close(); 
        }       
    } 
        
    public List openFile(String filename) throws IOException  {
     
        String basedir = WMAppContext.getInstance().getContext().getRealPath("/resources/uploads");  
        String filepath = basedir + "/" + filename;
        
        ArrayList<String> settings = new ArrayList<>();
        File fl = new File(filepath);
        FileInputStream fin = new FileInputStream(fl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
        String line = null;
        while ((line = reader.readLine()) != null) {  
            String match = "=";
            int index = line.indexOf(match);
            int length = line.length();
            String var1 = line.substring(0, index);
            String var2 = line.substring(index + 1, length);
            settings.add(var1);
            settings.add(var2);
        }
        reader.close(); 
        return settings; 
    }

    
}
    
    
    
    
    
    
    
    
    
    
    
    


