package pojo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class Data {

    private String team;
    private List<AlbumContents> photos;

    public String getTeam() {
        return team;
    }

    public Data setTeam(String team) {
        this.team = team;
        return this;
    }

    public List<AlbumContents> getPhotos() {
        return photos;
    }

    public Data setPhotos(List<AlbumContents> photos) {
        this.photos = photos;
        return this;
    }





}
