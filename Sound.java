package tom.sound;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Sound {
	
	public static void main(String[] args) {
		File file = new File(Messages.getString("Sound.0")); //$NON-NLS-1$
		Logger l = Logger.getLogger("l"); //$NON-NLS-1$
		Sound s = new Sound();
		s.init(l, file);
	}
	/*
	public void init(Logger l, File file) {
		Line clipline;
	Mixer.Info[] mixinfo = AudioSystem.getMixerInfo();
	for (Mixer.Info i : mixinfo) {
		l.info(i.getDescription() + "\n"); //$NON-NLS-1$
	}
	// mixinfo[2] is the default output
	// create mixer object from the system default output
	Mixer m = AudioSystem.getMixer(mixinfo[2]);
	l.info("created mixer m\n"); //$NON-NLS-1$
	// get audio line
	
	
	AudioFormat format = null;
	//specifies the class of line desired
	DataLine.Info lineinfo = new DataLine.Info(SourceDataLine.class, format);
	if (!AudioSystem.isLineSupported(lineinfo)) {
		// error handle
	}
	
	
	// obtain line
	try {
	Line sourceLine = m.getLine(lineinfo);
	AudioSystem.getAudioInputStream(file);
	
	
	// clip.setFramePosition(0);
	} catch (LineUnavailableException e) {
		// error handle
	}	
	// get info about line
		l.info("lines opened" + "\n");

}
*/
	
	public void init(Logger l, File file) {
		try {
			
			Clip clip = AudioSystem.getClip();
			//clip.addLineListener(LineListener());
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());
			clip.open(inputStream);
			
			
			
			FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(+2.0f);
			float f = clip.getLevel();
			String s = String.valueOf(f);
			l.info(s);
			clip.start();
			clip.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
