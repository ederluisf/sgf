package br.com.sgf.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file-upload")
@CrossOrigin(origins = "*")
public class FileUploadController {

	@PostMapping
	public void handleFileUpload(@RequestParam("file") MultipartFile file) {
		System.out.println("Nome do arquivo: " + file.getOriginalFilename());
	}
}
