import java.util.ArrayList;

public class Album {
    String albumTitle;
    ArrayList<Song> songs;

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.songs = new ArrayList<>();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(String title, double duration){
        if(findSong(title)==-1){
            songs.add(new Song(title, duration));
        }
    }

    public int findSong(String songTitle){
        for(Song song : songs){
            if(song.getSongTitle().equals(songTitle))
                return songs.indexOf(song);
        }
        return -1;
    }

}
