package com.som.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.som.service.FilesService;
import com.som.utility.Constants;
import com.som.utility.ResponseMessageDto;

@RestController
public class FilesController {

    @Autowired
    private FilesService filesService;

    @PostMapping("/uploadfile")
    public ResponseEntity<ResponseMessageDto> uploadSingleFile(@RequestParam MultipartFile file) throws IOException {

        ResponseMessageDto response = filesService.uploadSingleFile(file);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/uploadmultifile")
    public ResponseEntity<ResponseMessageDto> uploadMultipleFile(@RequestParam MultipartFile[] filess)
            throws IOException {

        List<ResponseMessageDto> uploadedFiles = filesService.uploadMultipleFile(filess);

        return ResponseEntity.ok(
                new ResponseMessageDto(
                        HttpURLConnection.HTTP_OK,
                        Constants.SUCCESS,
                        uploadedFiles
                )
        );
    }
}
