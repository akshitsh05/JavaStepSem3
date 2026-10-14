import java.util.Scanner;
import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int capacity) {
        songs = new String[Math.max(0, capacity)];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
            System.out.println("Song added successfully.");
        } else {
            System.out.println("Playlist is full.");
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }
}

class MusicPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum playlist capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(capacity);

        System.out.print("How many songs do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + " title: ");
            String song = sc.nextLine();
            p.addSong(song);
        }

        System.out.println("\nSongs in playlist:");
        String[] copy = p.getSongs();

        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        System.out.println("Total songs: " + p.getSongCount());

        sc.close();
    }
}