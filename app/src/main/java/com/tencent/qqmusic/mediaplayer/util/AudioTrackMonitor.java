package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor {
    private static final boolean ENABLE = false;
    private static final String TAG = "AudioTrackMonitor";
    private WeakReference<AudioTrack> mAudioTrackRef = null;
    private StringBuilder mBuilder = new StringBuilder(100);
    private long mLastPosition = 0;
    private long mLastTime = System.nanoTime();
    private int mLooperTime = 200;
    private Thread mMonitorThread = new 1(this, "Monitor-AudioTrack");
    private boolean mStop = false;

    public AudioTrackMonitor(AudioTrack audioTrack) {
        this.mAudioTrackRef = new WeakReference(audioTrack);
    }

    public void start() {
    }

    public void stop() {
    }
}
