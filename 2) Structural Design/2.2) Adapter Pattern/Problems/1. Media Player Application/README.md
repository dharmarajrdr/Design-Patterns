### Problem Statement: Media Player Application

You are developing a **media player application** that supports playing audio files. The application currently works with the following interface:

```java
interface AudioPlayer {
    void playAudio(String filename);
}
```

However, you now want to extend the functionality to also play **video files** using a third-party video player. The third-party video player provides the following class:

```java
class ThirdPartyVideoPlayer {
    public void playVideoFile(String videoFilePath) {
        System.out.println("Playing video: " + videoFilePath);
    }
}
```

### Requirement

Design a system using the **Adapter Design Pattern** so that your `AudioPlayer` interface can seamlessly support video playback through the `ThirdPartyVideoPlayer`.
