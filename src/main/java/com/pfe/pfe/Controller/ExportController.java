package com.pfe.pfe.Controller;

import com.pfe.pfe.Services.DBExportPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filePdf")
public class ExportController {

    @Autowired
    private DBExportPdf dbExportPdf;



}
