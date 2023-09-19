package com.kwon.gbraucp2.gallery;

import java.util.List;

public interface GalleryMapper {
	public abstract List<GalleryFile> get(GalleryFile gf);
	public abstract int upload(GalleryFile gf);
	
}
