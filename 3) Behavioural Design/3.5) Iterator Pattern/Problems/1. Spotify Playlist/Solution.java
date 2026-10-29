package com.dharmaraj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Song {

    final String title;
    final String artist;
    boolean favorite;
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public Song(String title, String artist, boolean favorite) {
        this.title = title;
        this.artist = artist;
        this.favorite = favorite;
    }
    public void markFavorite() {
        favorite = true;
    }
    public void unmarkFavorite() {
        favorite = false;
    }
}

// Iterator interface
interface PlaylistIterator {
    boolean hasNext();
    Song next();
}

class Playlist {

    final List<Song> songs;
    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }
}

class ForwardIterator implements PlaylistIterator {

    private final Playlist playlist;
    private int index;
    public ForwardIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < playlist.songs.size();
    }

    public Song next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more songs in the playlist");
        }
        return playlist.songs.get(index++);
    }
}

class FavouriteIterator implements PlaylistIterator {

    private final Playlist playlist;
    int index;
    public FavouriteIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    public boolean hasNext() {
        for(int i = index; i < playlist.songs.size(); ++i) {
            if (playlist.songs.get(i).favorite) {
                return true;
            }
        }
        return false;
    }

    public Song next() {
        while (index < playlist.songs.size()) {
            Song song = playlist.songs.get(index++);
            if (song.favorite) {
                return song;
            }
        }
        throw new IllegalStateException("No more favorite songs in the playlist");
    }
}

class ShuffleIterator implements PlaylistIterator {

    private final Playlist playlist;
    public ShuffleIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    public boolean hasNext() {
        return true;
    }

    public Song next() {
        Random rand = new Random();
        return playlist.songs.get(rand.nextInt(playlist.songs.size()));
    }
}

class PlaylistIteratorStrategy {

    public static PlaylistIterator getIterator(Playlist playlist, String type) {
        if (type.equals("forward")) {
            return new ForwardIterator(playlist);
        } else if (type.equals("favourite")) {
            return new FavouriteIterator(playlist);
        } else if (type.equals("shuffle")) {
            return new ShuffleIterator(playlist);
        } else {
            throw new IllegalArgumentException("Invalid iterator type");
        }
    }
}

public class Solution {

    private static List<Song> getSongs() {

        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Bloody Sweet", "Anirudh"));
        songs.add(new Song("Kovai Gethu", "Hiphop Thamizha"));
        songs.add(new Song("The nights", "Avicii", true));
        songs.add(new Song("Dheema Dheema", "Anirudh"));
        songs.add(new Song("Soulmate", "Arjit Singh", true));
        return songs;
    }

    private static void play(PlaylistIterator iterator) throws InterruptedException {
        for(int i = 0;i < 3 && iterator.hasNext();i++) {
            Song song = iterator.next();
            System.out.println(iterator.getClass().getName() + " : Playing '" + song.title + "'...");
            Thread.sleep(2000);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        List<Song> songs = getSongs();
        Playlist playlist = new Playlist(songs);
        PlaylistIteratorStrategy strategy = new PlaylistIteratorStrategy();
        play(strategy.getIterator(playlist, "shuffle"));
        play(strategy.getIterator(playlist, "favourite"));
        play(strategy.getIterator(playlist, "forward"));
    }
}