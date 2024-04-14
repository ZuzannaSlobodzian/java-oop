public class Song {
    private String songTitle;
    private double duration;

    public Song(String songTitle, double duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public String getSongTitle() {

        return songTitle;
    }

    @Override
    public String toString() {
        return "Tytuł piosenki: " + songTitle + ", " +
                "czas trwania: " + duration;
    }
}
