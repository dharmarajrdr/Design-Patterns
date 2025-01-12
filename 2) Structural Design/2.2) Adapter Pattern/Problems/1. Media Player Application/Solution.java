
interface AudioPlayer {

    void playAudio(String filename);
}

// Adaptee
class ThirdPartyVideoPlayer {

    public void playVideoFile(String videoFilePath) {
        System.out.println("Playing video: " + videoFilePath);
    }
}

// Adapter class
class VideoPlayerAdapter implements AudioPlayer {

    private ThirdPartyVideoPlayer videoPlayer;

    public VideoPlayerAdapter(ThirdPartyVideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void playAudio(String filename) {
        videoPlayer.playVideoFile(filename); // Adapting video playback for audio player
    }
}

public class Solution {

    public static void main(String[] args) {
        ThirdPartyVideoPlayer thirdPartyVideoPlayer = new ThirdPartyVideoPlayer();
        AudioPlayer videoAdapter = new VideoPlayerAdapter(thirdPartyVideoPlayer);

        videoAdapter.playAudio("/path/to/video/file"); // Playing video through adapter
    }
}
