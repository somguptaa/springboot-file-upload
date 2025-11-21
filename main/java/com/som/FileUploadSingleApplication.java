package com.som;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
        title = "File-Upload APIs",
        version = "1.0",
        description = "Single & Multiple File-Upload",
        contact = @Contact(name ="Som Gupta",email = "somgupta0011@gmail.com")))


@SpringBootApplication
public class FileUploadSingleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadSingleApplication.class, args);
	}

}
