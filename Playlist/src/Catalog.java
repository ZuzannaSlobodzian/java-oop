import java.util.ArrayList;

public class Catalog {
    String catalogTitle;
    ArrayList<Album> albums;

    public Catalog(String catalogTitle) {
        this.catalogTitle = catalogTitle;
        this.albums = new ArrayList<>();
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(String albumTitle) {
        if (findAlbum(albumTitle) == -1)
            albums.add(new Album(albumTitle));
        else
            System.out.println("Ten album juz istnieje");
    }

    public void addSongToAlbum(String albumTitle, String songTitle, double duration) {
        int index = findAlbum(albumTitle);
        if (index != -1)
            albums.get(index).addSong(songTitle, duration);
        else
            System.out.println("Ta piosenka juz istnieje");
    }

    public void printCatalog() {
        for (Album album : albums) {
            System.out.println("Album: " + album.getAlbumTitle());
            for (Song song : album.songs) {
                System.out.println(song.toString());
            }
        }
    }

    private int findAlbum(String albumTitle) {
        for (Album album : albums) {
            if (album.getAlbumTitle().equals(albumTitle))
                return albums.indexOf(album);
        }
        return -1;
    }
}

