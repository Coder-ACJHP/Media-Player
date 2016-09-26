
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class Main implements LineListener {

    //WAV
    private Clip clip;
    FloatControl gainControl;
    private boolean isPaused;
    private boolean isStopped = false;
    @SuppressWarnings("unused")
	private boolean playCompleted = false;
	@SuppressWarnings("unused")
	private boolean selectedwav = false;
    @SuppressWarnings("unused")
	private FileInputStream stream;
    private FileInputStream fis=null;
    @SuppressWarnings("unused")
	private BufferedInputStream bis=null;
    private int pausedOnFrame = 0;
    
    //MP3 
    AdvancedPlayer playMP3;
  
    

    public void Play(File selectedfile) throws JavaLayerException {

        try {
            selectedwav = true;
            if (selectedfile.getAbsolutePath().contains(".wav")) {
                AudioInputStream streamit = AudioSystem.getAudioInputStream(selectedfile);
                AudioFormat format = streamit.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.addLineListener(this);
                clip.open(streamit);
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

                while (clip.isRunning()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}

                    streamit.close();
                }
            } else {

                try {

                    fis = new FileInputStream(selectedfile.getAbsoluteFile());
                    bis = new BufferedInputStream(fis);
                    playMP3 = new AdvancedPlayer(fis);
                    playMP3.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent event) {
                            pausedOnFrame = event.getFrame();
                        }
                    });
                    playMP3.play(pausedOnFrame, Integer.MAX_VALUE);
                    playMP3.close();
                    
                } catch (FileNotFoundException | JavaLayerException e) {
                    System.out.println(e);
                }
            }
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("File Not Supported!");
        } catch (IOException ex) {
            System.out.println("File Not Found!");
        } catch (LineUnavailableException x) {
            System.out.println("Audio line for playing back is unavailable.");
        }

    }

    
    
    public void VolCon(float i) {
        gainControl.setValue(i);
    }

    public void Stop() {
        if (selectedwav = true) {
            clip.stop();
        } else {
            playMP3.stop();
        }
    }

    public void pause() throws JavaLayerException {
        if (selectedwav = true) {
            clip.stop();
        } else {
            playMP3.stop();
        }
    }

    public void resume() throws JavaLayerException {
        if (selectedwav = true) {
            clip.start();
        } else {
            playMP3.play();
        }
    }

    public void Update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
        if (isStopped || !isPaused) {
            playCompleted = true;
        }

    }

    public static void main(String[] args) {

    }

    @Override
    public void update(LineEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
