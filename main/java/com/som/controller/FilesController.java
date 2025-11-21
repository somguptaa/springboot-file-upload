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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "FilesController Controller",description = "FileUpload Single, Multiple")

@RestController
public class FilesController {

    @Autowired
    private FilesService filesService;

    @Operation(summary = "Single File-Upload",description = "Single File-Upload In The Database")
    @ApiResponses({
     @ApiResponse(responseCode = "201",description = "Single File-Upload Successfully"),
     @ApiResponse(responseCode = "400",description = "Single File-Upload Failed"),
     @ApiResponse(responseCode = "500",description = "Internal Server Error")})
    
    
    @PostMapping("/uploadfile")
    public ResponseEntity<ResponseMessageDto> uploadSingleFile(@RequestParam MultipartFile file) throws IOException {

        ResponseMessageDto response = filesService.uploadSingleFile(file);
        return ResponseEntity.ok(response);
    }

    
    @Operation(summary = "Multiple File-Upload",description = "Multiple File-Upload In The Database")
    @ApiResponses({
     @ApiResponse(responseCode = "201",description = "Multiple File-Upload Successfully"),
     @ApiResponse(responseCode = "400",description = "Multiple File-Upload Failed"),
     @ApiResponse(responseCode = "500",description = "Internal Server Error")})
    
    @PostMapping("/uploadmultifile")
    public ResponseEntity<ResponseMessageDto> uploadMultipleFile(@RequestParam MultipartFile[] filess)throws IOException {

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
