package pojo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AlbumContents {

    private String album_name;
    private int photos;

    public String getAlbum_name() {
        return album_name;
    }

    public AlbumContents setAlbum_name(String album_name) {
        this.album_name = album_name;
        return this;
    }

    public int getPhotos() {
        return photos;
    }

    public AlbumContents setPhotos(int photos) {
        this.photos = photos;
        return this;
    }




}
