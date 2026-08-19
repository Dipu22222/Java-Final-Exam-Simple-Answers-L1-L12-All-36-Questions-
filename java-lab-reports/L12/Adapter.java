// Target interface expected by the client
interface MediaPlayer {
    void play(String fileName);
}

// Adaptee — incompatible interface
class AdvancedMediaPlayer {
    void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter — makes AdvancedMediaPlayer usable via the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    @Override
    public void play(String fileName) {
        advancedPlayer.playMp4(fileName);
    }
}

public class Adapter {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("song.mp4");
    }
}
