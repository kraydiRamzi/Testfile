package com.pfe.pfe.Controller;

import com.pfe.pfe.Model.DBFile;

import com.pfe.pfe.Services.DBFileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private DBFileStorageService dbFileStorageService;
    

    private DBFile dbFile;

    @PostMapping
    public DBFile uploadfile(@RequestParam("file")MultipartFile file) {
    return dbFileStorageService.storeFile(file);
    }

    @GetMapping("/{id}")
    public DBFile getfile(@PathVariable String id){
        return dbFileStorageService.getFileById(id);
    }

    @GetMapping("/list")
    public List<DBFile> FileList(){
        return dbFileStorageService.getFileList();
    }

    @GetMapping("/data")
    public Byte[] DataExport (){
        return dbFileStorageService.DataExport();
    }
}
