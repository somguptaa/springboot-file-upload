package com.som.service;

import java.io.IOException;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.som.utility.ResponseMessageDto;

public interface FilesService {

    ResponseMessageDto uploadSingleFile(MultipartFile file) throws IOException;

    List<ResponseMessageDto> uploadMultipleFile(MultipartFile[] files) throws IOException;

	}



