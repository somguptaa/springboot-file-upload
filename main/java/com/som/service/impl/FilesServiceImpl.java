package com.som.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.som.entity.FilesEntity;
import com.som.repository.FilesRepository;
import com.som.service.FilesService;
import com.som.utility.Constants;
import com.som.utility.ResponseMessageDto;

@Service
public class FilesServiceImpl implements FilesService {


	
	@Autowired
	private FilesRepository filesRepository;
	 @Override
	    public ResponseMessageDto uploadSingleFile(MultipartFile file) throws IOException {

	        FilesEntity files = new FilesEntity();
	        files.setFileName(file.getOriginalFilename());
	        files.setFileType(file.getContentType());
	        files.setData(file.getBytes());
	        filesRepository.save(files);

	        return new ResponseMessageDto(
	                HttpURLConnection.HTTP_CREATED,
	                Constants.SUCCESS,
	                "File Inserted Successfully",
	                file.getOriginalFilename());
	    }
	 
	 
	 @Override
	    public List<ResponseMessageDto> uploadMultipleFile(MultipartFile[] files) throws IOException {

	        List<ResponseMessageDto> uploadedFiles = new ArrayList<>();

	        for (MultipartFile mf : files) {
	            uploadedFiles.add(uploadSingleFile(mf)); // reusing single upload method 
	        }

	        return uploadedFiles;
	    }
	 
	 
	 
	 
	 
	 
	}