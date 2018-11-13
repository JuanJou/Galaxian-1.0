package Logica;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip SHOOT = Applet.newAudioClip(Sound.class.getResource("/Sonido/laser.wav"));
	public static final AudioClip START = Applet.newAudioClip(Sound.class.getResource("/Sonido/victory.wav"));
	public static final AudioClip OVER = Applet.newAudioClip(Sound.class.getResource("/Sonido/lost.wav"));
	public static final AudioClip COL=Applet.newAudioClip(Sound.class.getResource("/Sonido/alien.wav"));
	public static final AudioClip WIN=Applet.newAudioClip(Sound.class.getResource("/Sonido/WINWIN.wav"));
	public static final AudioClip PO=Applet.newAudioClip(Sound.class.getResource("/Sonido/POWER.wav"));
	public static final AudioClip BEGIN=Applet.newAudioClip(Sound.class.getResource("/Sonido/BEGIN.wav"));
	public static final AudioClip CRASH=Applet.newAudioClip(Sound.class.getResource("/Sonido/wrong.wav"));
	public static final AudioClip PRI=Applet.newAudioClip(Sound.class.getResource("/Sonido/inicio.wav"));
}
