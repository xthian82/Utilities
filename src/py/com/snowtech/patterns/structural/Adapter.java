package py.com.snowtech.patterns.structural;


/**
 * Adapter pattern works as a bridge between two incompatible interfaces. This type of design 
 * pattern comes under structural pattern as this pattern combines the capability of two 
 * independent interfaces.
 * 
 * This pattern involves a single class which is responsible to join functionalities of 
 * independent or incompatible interfaces. A real life example could be a case of card 
 * reader which acts as an adapter between memory card and a laptop. You plugin the memory 
 * card into card reader and card reader into the laptop so that memory card can be read 
 * via laptop. 
 * 
 * We are demonstrating use of Adapter pattern via following example in which an audio 
 * player device can play mp3 files only and wants to use an advanced audio player capable 
 * of playing vlc and mp4 files.
 * 
 * IMPLEMENTATION
 * ==============
 * We have a MediaPlayer interface and a concrete class AudioPlayer implementing the 
 * MediaPlayer interface. AudioPlayer can play mp3 format audio files by default.
 * 
 * We are having another interface AdvancedMediaPlayer and concrete classes implementing 
 * the AdvancedMediaPlayer interface. These classes can play vlc and mp4 format files. 
 * 
 * We want to make AudioPlayer to play other formats as well. To attain this, we have 
 * created an adapter class MediaAdapter which implements the MediaPlayer interface and 
 * uses AdvancedMediaPlayer objects to play the required format. 
 * 
 * AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without 
 * knowing the actual class which can play the desired format. 
 * 
 * Adapter, our demo class will use AudioPlayer class to play various formats.

 * @author cristhian
 *
 */

interface MediaPlayer {
	public void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {	
	public void playVlc(String fileName);
	public void playMp4(String fileName);
}


class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// do nothing
	}
}

class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// do nothing
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: " + fileName);
	}
}

class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcPlayer();

		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer.playMp4(fileName);
		}
	}
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		// inbuilt support to play mp3 music files
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		}

		// mediaAdapter is providing support to play other file formats
		else if (audioType.equalsIgnoreCase("vlc")|| audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}

		else {
			System.out.println("Invalid media. " + audioType
					+ " format not supported");
		}
	}
}

public class Adapter {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
