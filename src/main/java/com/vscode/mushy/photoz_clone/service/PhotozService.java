package com.vscode.mushy.photoz_clone.service;

import org.springframework.stereotype.Service;

import com.vscode.mushy.photoz_clone.model.Photo;
import com.vscode.mushy.photoz_clone.repository.PhotozRepository;

@Service
public class PhotozService {

	private final PhotozRepository photozRepository;

	public PhotozService(PhotozRepository photozRepository)
	{
		this.photozRepository = photozRepository;
	}



    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

	public Photo get(Integer id)
	{
		return photozRepository.findById(id).orElse(null);
	}

	public void remove(Integer id)
	{
		photozRepository.deleteById(id);
	}

	public Photo save(String fileName, String contentType, byte[] data)
	{
		Photo photo = new Photo();
		photo.setFileName(fileName);
		photo.setContentType(contentType);
		photo.setData(data);
		photozRepository.save(photo);
		return photo;
	}
}
