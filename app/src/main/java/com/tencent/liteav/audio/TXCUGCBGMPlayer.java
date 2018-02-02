package com.tencent.liteav.audio;

import android.media.AudioTrack;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer implements Runnable {
    private static final int PLAY_ERR_AUDIO_TRACK = -3;
    private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
    private static final int PLAY_ERR_FILE_NOTFOUND = -2;
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
    private static TXCUGCBGMPlayer instance;
    private long mEndTimeMS = 0;
    private String mFilePath = null;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private long mSeekBytes = 0;
    private float mSpeedRate = 1.0f;
    private long mStartTimeMS = 0;
    private Thread mThread = null;
    private float mVolume = 1.0f;
    private WeakReference<f> mWeakListener = null;

    private native int nativeGetBitsPerChannel();

    private native int nativeGetChannels();

    private native long nativeGetCurDurationMS();

    private native long nativeGetCurPosition();

    private native long nativeGetCurPtsMS();

    private static native long nativeGetDurationMS(String str);

    private native int nativeGetSampleRate();

    private native void nativePause();

    private native void nativePlayFromTime(long j, long j2);

    private native int nativeRead(byte[] bArr, int i);

    private native void nativeResume();

    private native void nativeSeekBytes(long j);

    private native void nativeSetSpeedRate(float f);

    private native void nativeSetVolume(float f);

    private native boolean nativeStartPlay(String str);

    private native void nativeStopPlay();

    static {
        a.d();
    }

    public static TXCUGCBGMPlayer getInstance() {
        if (instance == null) {
            synchronized (TXCUGCBGMPlayer.class) {
                if (instance == null) {
                    instance = new TXCUGCBGMPlayer();
                }
            }
        }
        return instance;
    }

    private TXCUGCBGMPlayer() {
    }

    public synchronized void setOnPlayListener(f fVar) {
        if (fVar == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference(fVar);
    }

    public void startPlay(String str) {
        TXCLog.i(TAG, "startPlay:" + str);
        if (str != null && !str.isEmpty()) {
            if (this.mIsRunning) {
                TXCLog.w(TAG, "BGM正在播放中，将重新启动");
                stopPlay();
            }
            this.mIsPause = false;
            this.mSeekBytes = 0;
            this.mFilePath = str;
            this.mIsRunning = true;
            this.mThread = new Thread(this, "UGCBGMPlayer");
            this.mThread.start();
        }
    }

    public void stopPlay() {
        TXCLog.i(TAG, "stopPlay");
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.mThread == null || !this.mThread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
            try {
                this.mThread.join();
            } catch (InterruptedException e) {
            }
        }
        this.mThread = null;
        synchronized (this) {
            nativeStopPlay();
        }
        TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void pause() {
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        nativePause();
    }

    public void resume() {
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        nativeResume();
    }

    public void setVolume(float f) {
        this.mVolume = f;
        nativeSetVolume(f);
    }

    public void setSpeedRate(float f) {
        TXCLog.i(TAG, "setSpeedRate:" + f);
        this.mSpeedRate = f;
        nativeSetSpeedRate(f);
    }

    public void playFromTime(long j, long j2) {
        TXCLog.i(TAG, "playFromTime:" + j + ", " + j2);
        this.mStartTimeMS = j;
        this.mEndTimeMS = j2;
        nativePlayFromTime(j, j2);
    }

    public void seekBytes(long j) {
        TXCLog.i(TAG, "seekBytes:" + j);
        if (j < 0) {
            TXCLog.e(TAG, "seek bytes can not be negative. change to 0");
            j = 0;
        }
        this.mSeekBytes = j;
        nativeSeekBytes(j);
    }

    public long getCurPosition() {
        long nativeGetCurPosition = nativeGetCurPosition();
        TXCLog.i(TAG, "getCurPosition:" + nativeGetCurPosition);
        return nativeGetCurPosition;
    }

    public static long getDurationMS(String str) {
        return nativeGetDurationMS(str);
    }

    private void onPlayStart() {
        f fVar = null;
        synchronized (this) {
            if (this.mWeakListener != null) {
                fVar = (f) this.mWeakListener.get();
            }
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    private void onPlayEnd(int i) {
        f fVar = null;
        synchronized (this) {
            if (this.mWeakListener != null) {
                fVar = (f) this.mWeakListener.get();
            }
        }
        if (fVar != null) {
            fVar.a(i);
        }
    }

    private void onPlayProgress(long j, long j2) {
        f fVar = null;
        synchronized (this) {
            if (this.mWeakListener != null) {
                fVar = (f) this.mWeakListener.get();
            }
        }
        if (fVar != null) {
            fVar.a(j, j2);
        }
    }

    public void run() {
        int i;
        AudioTrack audioTrack;
        int i2 = 3;
        long currentTimeMillis = System.currentTimeMillis();
        onPlayStart();
        if (this.mFilePath == null || this.mFilePath.isEmpty()) {
            TXCLog.e(TAG, "file path = " + this.mFilePath);
            i = -2;
            audioTrack = null;
        } else {
            nativeSetVolume(this.mVolume);
            nativeSetSpeedRate(this.mSpeedRate);
            nativePlayFromTime(this.mStartTimeMS, this.mEndTimeMS);
            nativeSeekBytes(this.mSeekBytes);
            if (nativeStartPlay(this.mFilePath)) {
                int i3;
                if (this.mIsPause) {
                    nativePause();
                } else {
                    nativeResume();
                }
                TXCLog.i(TAG, "start play bgm: path = " + this.mFilePath + "volume = " + this.mVolume + ", speedRate = " + this.mSpeedRate + ", startTime = " + this.mStartTimeMS + ", endTime = " + this.mEndTimeMS + ", seekBytes = " + this.mSeekBytes + ", pause = " + this.mIsPause);
                int nativeGetSampleRate = nativeGetSampleRate();
                int nativeGetChannels = nativeGetChannels();
                int nativeGetBitsPerChannel = nativeGetBitsPerChannel();
                if (nativeGetChannels == 1) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                if (nativeGetBitsPerChannel != 8) {
                    i2 = 2;
                }
                try {
                    AudioTrack audioTrack2 = new AudioTrack(3, nativeGetSampleRate, i3, i2, AudioTrack.getMinBufferSize(nativeGetSampleRate, i3, i2), 1);
                    try {
                        audioTrack2.play();
                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                        while (this.mIsRunning && !Thread.interrupted()) {
                            nativeGetSampleRate = nativeRead(bArr, Downloads.RECV_BUFFER_SIZE);
                            if (nativeGetSampleRate < 0) {
                                TXCLog.i(TAG, "UGC BGM播放结束");
                                onPlayProgress(nativeGetCurDurationMS(), nativeGetCurDurationMS());
                                audioTrack = audioTrack2;
                                i = 0;
                                break;
                            } else if (nativeGetSampleRate != 0) {
                                audioTrack2.write(bArr, 0, nativeGetSampleRate);
                                onPlayProgress(nativeGetCurPtsMS(), nativeGetCurDurationMS());
                            } else if (this.mIsPause) {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                        audioTrack = audioTrack2;
                        i = 0;
                    } catch (Exception e2) {
                        TXCLog.e(TAG, "AudioTrack play Exception: " + e2.getMessage());
                        audioTrack = audioTrack2;
                        i = -4;
                    }
                } catch (Exception e3) {
                    TXCLog.e(TAG, "new AudioTrack Exception: " + e3.getMessage());
                    i = -3;
                    audioTrack = null;
                }
            } else {
                i = -1;
                audioTrack = null;
            }
        }
        if (audioTrack != null) {
            try {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            } catch (Exception e4) {
            }
        }
        TXCLog.i(TAG, "UGC BGM player play time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (this.mIsRunning) {
            onPlayEnd(i);
        }
    }
}
