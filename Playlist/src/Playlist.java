import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist{
    private String playlistTitle;
    LinkedList<Song> playlist;

    public Playlist(String playlistTitle) {
        this.playlistTitle = playlistTitle;
        this.playlist = new LinkedList<>();
    }

    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void addSongToPlaylist(Song song){
        playlist.add(song);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> playlistIterator = playlist.listIterator();
        boolean goingForward = true;
        boolean quit = false;
        while(!quit){
            System.out.println("Co zagrac?");
            String choice = scanner.next();
            switch (choice) {
                case "next":
                    if (!goingForward) {
                        if (playlistIterator.hasNext())
                            playlistIterator.next();
                        goingForward = true;
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println(playlistIterator.next().toString());
                    } else {
                        System.out.println("Koniec listy");
                    }
                    break;
                case "previous":
                    if (goingForward) {
                        if (playlistIterator.hasPrevious())
                            playlistIterator.previous();
                        goingForward = false;
                    }
                    if (playlistIterator.hasPrevious()) {
                        System.out.println(playlistIterator.previous().toString());
                    } else {
                        System.out.println("Poczatek listy");
                    }
                    break;
                case "reply":
                    if (!goingForward) {
                        if (playlistIterator.hasNext())
                            System.out.println(playlistIterator.next().toString());
                        goingForward = true;
                    }
                    else {
                        System.out.println(playlistIterator.previous().toString());
                        playlistIterator.next();
                          }
                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    System.out.println("Zle wprowadzona komenda");
                }
            }
    }
    public void removeSong(String title){
        ListIterator<Song> playlistIterator = playlist.listIterator();
        while(playlistIterator.hasNext()){
            if(playlistIterator.next().getSongTitle().equals(title))
                playlistIterator.remove();
        }
    }
    public void printPlaylist(){
        ListIterator<Song> playlistIterator = playlist.listIterator();
        while(playlistIterator.hasNext()){
            System.out.println(playlistIterator.next().toString());
        }
    }
}
