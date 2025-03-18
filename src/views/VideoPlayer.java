package views;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;

import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

public class VideoPlayer extends JFrame {

    private EmbeddedMediaPlayer mediaPlayer;
    private Runnable onVideoFinished;

    public VideoPlayer(String videoPath, Runnable onVideoFinished) {
        this.onVideoFinished = onVideoFinished;
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        mediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
        
        Canvas canvas = new Canvas();
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);

        mediaPlayer.media().play(videoPath);

        mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                dispose();
                if(onVideoFinished != null) {
                    onVideoFinished.run();
                }
            }
        });
    }
}