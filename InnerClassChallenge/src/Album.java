import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }


    public boolean addSong(String title, double duration) {
        return songs.addSong(new Song(title, duration));

    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index < this.songs.songs.size()) {
            playList.add(this.songs.songs.get(index));
            return true;
        } else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        } else {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
    }
    private class SongList{
        private ArrayList<Song> songs;
        public SongList(){
            this.songs = new ArrayList<Song>();
        }

        public boolean addSong(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            Iterator var2 = this.songs.iterator();

            Song checkedSong;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                checkedSong = (Song)var2.next();
            } while(!checkedSong.getTitle().equals(title));

            return checkedSong;
        }
    }
}
