package com.company.controller;


import com.company.service.DeveloperService;
import com.company.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/uploadFromExcel")
    public String upload(@RequestParam("file") MultipartFile file)
    {
        try{
            excelService.saveExcelData(file);
            return "Excel data Uploaded";
        }
        catch (Exception e) {
            return "Error : Can not upload data";
        }
    }

}
