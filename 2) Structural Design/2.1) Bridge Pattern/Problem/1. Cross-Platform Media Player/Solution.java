
/**
 * The bridge is the association between the MediaPlayer abstraction and the
 * MediaFormat implementation. Specifically, the bridge is the reference to
 * MediaFormat inside the MediaPlayer class. This bridge allows MediaPlayer to
 * delegate format-specific behavior to MediaFormat without being tightly
 * coupled to a particular implementation, enabling flexibility and
 * extensibility.
 */

interface MediaFormat {

    void play();

    void pause();

    void stop();
}

abstract class MediaPlayer {

    // Bridge
    protected MediaFormat mediaFormat;

    public MediaPlayer(MediaFormat mediaFormat) {
        this.mediaFormat = mediaFormat;
    }

    abstract void play();

    abstract void pause();

    abstract void stop();
}

class MP4Player implements MediaFormat {

    @Override
    public void play() {
        System.out.println("Playing MP4 format.");
    }

    @Override
    public void pause() {
        System.out.println("Pausing MP4 format.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MP4 format.");
    }
}

class MP3Player implements MediaFormat {

    @Override
    public void play() {
        System.out.println("Playing MP3 format.");
    }

    @Override
    public void pause() {
        System.out.println("Pausing MP3 format.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MP3 format.");
    }
}

class WindowsMediaPlayer extends MediaPlayer {

    public WindowsMediaPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    void play() {
        System.out.println("Windows: ");
        mediaFormat.play();
    }

    @Override
    void pause() {
        System.out.println("Windows: ");
        mediaFormat.pause();
    }

    @Override
    void stop() {
        System.out.println("Windows: ");
        mediaFormat.stop();
    }
}

class LinuxMediaPlayer extends MediaPlayer {

    public LinuxMediaPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    void play() {
        System.out.println("Linux: ");
        mediaFormat.play();
    }

    @Override
    void pause() {
        System.out.println("Linux: ");
        mediaFormat.pause();
    }

    @Override
    void stop() {
        System.out.println("Linux: ");
        mediaFormat.stop();
    }
}

public class Solution {

    public static void main(String[] args) {

        MediaPlayer windowsPlayer = new WindowsMediaPlayer(new MP4Player());
        windowsPlayer.play();

        MediaPlayer linuxPlayer = new LinuxMediaPlayer(new MP3Player());
        linuxPlayer.play();
    }
}
