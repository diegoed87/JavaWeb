package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class IndexMB {
	
	private List<String> images;
	
	@PostConstruct
	public void init() {
		images = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			images.add("mecanica"+i+".jpg");
		}
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	

}
