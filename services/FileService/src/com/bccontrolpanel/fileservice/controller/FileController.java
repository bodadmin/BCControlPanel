/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.bccontrolpanel.fileservice.controller;

import com.bccontrolpanel.fileservice.FileService;
import java.lang.String;
import java.io.IOException;
import java.lang.Exception;
import com.wavemaker.runtime.file.model.DownloadResponse;
import javax.servlet.http.HttpServletRequest;
import com.bccontrolpanel.fileservice.FileService.WMFile;
import org.springframework.web.multipart.MultipartFile;
import com.bccontrolpanel.fileservice.FileService.FileUploadResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/files", method = RequestMethod.POST)
    public WMFile[] listFiles(HttpServletRequest httpServletRequest, @RequestParam(value = "relativePath", required = false) String relativePath) throws IOException {
        return fileService.listFiles(httpServletRequest, relativePath);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public FileUploadResponse[] uploadFile(@RequestPart(value = "files") MultipartFile[] files, @RequestParam(value = "relativePath", required = false) String relativePath, HttpServletRequest httpServletRequest) {
        return fileService.uploadFile(files, relativePath, httpServletRequest);
    }

    @RequestMapping(value = "/downloadFile", produces = "application/octet-stream", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getDownloadFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFile(file, returnName);
    }

    @RequestMapping(value = "/downloadFileAsInline", produces = "application/octet-stream", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getDownloadFileAsInline(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFileAsInline(file, returnName);
    }

    @RequestMapping(value = "/file", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteFile(@RequestParam(value = "file", required = false) String file) throws IOException {
        return fileService.deleteFile(file);
    }
}
