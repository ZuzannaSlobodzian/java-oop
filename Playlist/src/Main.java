import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static Catalog catalog = new Catalog("goodsOfRap");
    static Playlist playlist = new Playlist("Poeby");

    public static void main(String[] args) {

    createCatalog();
    createPlaylist();
    }

    public static void createCatalog(){
        catalog.addAlbum("Eminem");
        catalog.addAlbum("Mata");
        catalog.addSongToAlbum("Eminem", "America", 3.4);
        catalog.addSongToAlbum("Eminem", "Closet", 5.8);
        catalog.addSongToAlbum("Mata", "Schodki", 8.8);
        catalog.addSongToAlbum("Eminem", "Stan", 2.2);
        catalog.addSongToAlbum("Mata", "Kiss", 1.45);
        catalog.printCatalog();



//        boolean createAlbums = true;
//        while(createAlbums){
//            System.out.println("Co chcesz poczac?");
//            String choice = scanner.next();
//            switch(choice){
//                case "addAlbum":
//                    addAlbum();
//                    break;
//                case "addSong":
//                    addSong();
//                    break;
//                case "quit":
//                    createAlbums = false;
//                    break;
//                case "printAll":
//                    catalog.printCatalog();
//                    break;
//                default:
//                    System.out.println("Zle wprowadzona komenda");
            }


    static void createPlaylist(){
        boolean createPlaylist = true;
        while(createPlaylist){
            System.out.println("Co chcesz poczac dalej?");
            String choice = scanner.next();
            switch(choice){
                case "add":
                    addToPlaylist();
                    break;
                case "play":
                    playlist.play();
                    break;
                case "remove":
                    removeFromPlaylist();
                    break;
                case "print":
                    playlist.printPlaylist();
                    break;
                case "quit":
                    createPlaylist = false;
                    break;
                default:
                    System.out.println("Zle wprowadzona komenda");
            }
        }
    }
    public static void addToPlaylist(){
        System.out.println("Podaj nazwę piosenki");
        String songTitle = scanner.next();

        for(Album album : catalog.albums) {
            int index = album.findSong(songTitle);
            if(index!=-1) {
                playlist.addSongToPlaylist(album.songs.get(index));
                return;
            }
        }
        System.out.println("Podanej piosenki nie ma w katalogu.");
    }

    public static void removeFromPlaylist(){
        System.out.println("Podaj nazwę piosenki");
        String songTitle = scanner.next();
        playlist.removeSong(songTitle);
    }

    public static void addAlbum(){
        System.out.println("podaj nazwę albumu");
        String albumTitle = scanner.next();
        catalog.addAlbum(albumTitle);
    }

    public static void addSong(){
        System.out.println("podaj nazwę albumu");
        String albumTitle = scanner.next();
        System.out.println("podaj nazwę piosenki");
        String songTitle = scanner.next();
        System.out.println("podaj czas trwania piosenki");
        double duration = scanner.nextDouble();
        catalog.addSongToAlbum(albumTitle, songTitle, duration);
    }

}