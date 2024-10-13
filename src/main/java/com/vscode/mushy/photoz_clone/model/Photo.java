package com.vscode.mushy.photoz_clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table("PHOTOZ")
public class Photo {

	@Id
	private Integer id;

	@jakarta.validation.constraints.NotEmpty(message = "File name is mandatory")
	private String fileName;

	@JsonIgnore
	private byte[] data;

	private String contentType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public byte[] getData() {
        return data;
    }

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

}
