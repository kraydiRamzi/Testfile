package com.pfe.pfe.Services;

import com.pfe.pfe.Model.DBFile;
import com.pfe.pfe.Repository.DBFileRepo;
import com.pfe.pfe.Exception.FileStorageException;
import com.pfe.pfe.Exception.MyFileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;



@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepo dbFileRepo;

    private DBFile dbFile;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.equals("")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(UUID.randomUUID().toString(),fileName,file.getContentType(),file.getBytes());
            /*(fileName, file.getContentType(), file.getBytes());*/

            return dbFileRepo.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFileById(String fileId) {

        return dbFileRepo.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public List<DBFile> getFileList(){
        return dbFileRepo.findAll();
    }
/*
    public List<> readUsingClass(String fileId)
            throws IOException
    {
        // Creating an object of Path class
        Path path = Paths.get(fileId);

        // To read file to byte array
        byte[] bytes = Files.readAllBytes(path);

        // Display message only
        System.out.println(
                "Read text file using Files class");

        // Reading the file to String List
        @SuppressWarnings("unused")

        // Creating a List class object of string type
        // as data in file to be read is words
        List<String> allLines = Files.readAllLines(
                path, StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
        return allLines;

    }
*/

        public Byte[] DataExport (){
            byte[] myBytes= dbFile.getData();
            InputStream myInputStream = new ByteArrayInputStream(myBytes);
            System.out.println(myInputStream);
            return new Byte[0];
        }

    }
