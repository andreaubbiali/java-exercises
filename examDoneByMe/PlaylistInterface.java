import java.util.List;
import java.util.Set;

public interface PlaylistInterface {

    void aggiungiBrano(Album.Brano b);

    void rimuoviBrano(Album.Brano b);

    boolean isPresent(Album.Brano b);

    int getPosition(Album.Brano b);

    List<Album.Brano> getBraniByAlbum(Album a);

    Set<Album> getAllAlbums();

}
