package br.com.sgf.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

	@PostMapping
	public void handleFileUpload(@RequestParam("file") MultipartFile file) {
		log.info("File Uploaded: {}", file.getOriginalFilename());
	}
}
