package com.vscode.mushy.photoz_clone.repository;

import org.springframework.data.repository.CrudRepository;

import com.vscode.mushy.photoz_clone.model.Photo;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
	
	
}
