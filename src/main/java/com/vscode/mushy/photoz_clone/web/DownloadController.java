package com.vscode.mushy.photoz_clone.web;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vscode.mushy.photoz_clone.model.Photo;
import com.vscode.mushy.photoz_clone.service.PhotozService;

@RestController
public class DownloadController {



	/*
	 * This is called constructor dependency injection
	 * As we have already initialized the db at photozService class
	 * and we have put on @Service on it so the spring already knows what it is
	 */


		private final PhotozService photozService;

	public DownloadController(PhotozService photozService)
	{
		this.photozService = photozService;
	}


	/* Following Function Returns the requested photo from the Db
	 * Following Steps 
	 * Find the photo from the db using the pathVariable
	 * Make https headers to send with the response
	 * retuen new ResponseEntity with data headers and status.ok
	 * if no photo of matching id throw new error of ResponseStatus exception
	 * This function is also my introduction to dependency injection
	*/

	@GetMapping("/download/{id}")

	public ResponseEntity<byte[]> download(@PathVariable Integer id)
	{
		Photo photo = photozService.get(id);
		if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		byte[] data = photo.getData();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(photo.getContentType()));
		ContentDisposition build = ContentDisposition.inline().filename(photo.getFileName()).build(); // inline to just display the photo to the screen build to download the file
		headers.setContentDisposition(build);
		return new ResponseEntity<>(data,headers,HttpStatus.OK);

	}
}
