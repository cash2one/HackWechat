package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer implements OnCompletionListener, OnErrorListener {
    public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
    public static final int TRAE_MEDIAPLAER_STOP = 100;
    private Context _context;
    private int _durationMS = -1;
    private boolean _hasCall = false;
    private boolean _loop = false;
    int _loopCount = 0;
    private int _prevVolume = -1;
    boolean _ringMode = false;
    private int _streamType = 0;
    private Timer _watchTimer = null;
    private TimerTask _watchTimertask = null;
    private a mCallback;
    private MediaPlayer mMediaPlay = null;

    public TraeMediaPlayer(Context context, a aVar) {
        this._context = context;
        this.mCallback = aVar;
    }

    public boolean playRing(int i, int i2, Uri uri, String str, boolean z, int i3, boolean z2, boolean z3, int i4) {
        AudioManager audioManager;
        int i5;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "TraeMediaPlay | playRing datasource:" + i + " rsid:" + i2 + " uri:" + uri + " filepath:" + str + " loop:" + (z ? "Y" : "N") + " :loopCount" + i3 + " ringMode:" + (z2 ? "Y" : "N") + " hasCall:" + z3 + " cst:" + i4);
        }
        if (z || i3 > 0) {
            AssetFileDescriptor openRawResourceFd;
            MediaPlayer mediaPlayer;
            try {
                if (this.mMediaPlay != null) {
                    boolean isPlaying = this.mMediaPlay.isPlaying();
                    if (isPlaying) {
                        return isPlaying;
                    }
                    mediaPlayer = this.mMediaPlay;
                    mediaPlayer.release();
                    this.mMediaPlay = mediaPlayer;
                }
            } catch (Exception e) {
                mediaPlayer = e;
                this.mMediaPlay = mediaPlayer;
                if (this._watchTimer != null) {
                    this._watchTimer.cancel();
                    this._watchTimer = null;
                    this._watchTimertask = null;
                }
                audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                this.mMediaPlay = new MediaPlayer();
                if (this.mMediaPlay != null) {
                    this.mMediaPlay.setOnCompletionListener(this);
                    this.mMediaPlay.setOnErrorListener(this);
                    switch (i) {
                        case 0:
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | rsid:" + i2);
                            }
                            openRawResourceFd = this._context.getResources().openRawResourceFd(i2);
                            if (openRawResourceFd == null) {
                                this.mMediaPlay.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                                openRawResourceFd.close();
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | afd == null rsid:" + i2);
                            }
                            this.mMediaPlay.release();
                            this.mMediaPlay = null;
                            return false;
                        case 1:
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | uri:" + uri);
                            }
                            this.mMediaPlay.setDataSource(this._context, uri);
                            break;
                        case 2:
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | FilePath:" + str);
                            }
                            this.mMediaPlay.setDataSource(str);
                            break;
                        default:
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | err datasource:" + i);
                            }
                            this.mMediaPlay.release();
                            this.mMediaPlay = null;
                            break;
                    }
                    if (this.mMediaPlay == null) {
                        return false;
                    }
                    this._ringMode = z2;
                    i5 = 0;
                    if (this._ringMode) {
                        this._streamType = 2;
                        i5 = 1;
                    } else {
                        this._streamType = 0;
                        if (VERSION.SDK_INT >= 11) {
                            i5 = 3;
                        }
                    }
                    this._hasCall = z3;
                    if (this._hasCall) {
                        this._streamType = i4;
                    }
                    this.mMediaPlay.setAudioStreamType(this._streamType);
                    this.mMediaPlay.prepare();
                    this.mMediaPlay.setLooping(z);
                    this.mMediaPlay.start();
                    this._loop = z;
                    if (!this._loop) {
                        this._loopCount = i3;
                        this._durationMS = this._loopCount * this.mMediaPlay.getDuration();
                    } else {
                        this._loopCount = 1;
                        this._durationMS = -1;
                    }
                    this._loopCount--;
                    if (!this._hasCall) {
                        audioManager.setMode(i5);
                    }
                    if (this._durationMS > 0) {
                        this._watchTimer = new Timer();
                        this._watchTimertask = new 1(this);
                        this._watchTimer.schedule(this._watchTimertask, (long) (this._durationMS + 1000));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | DurationMS:" + this.mMediaPlay.getDuration() + " loop:" + z);
                    }
                    return true;
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                return false;
            } catch (IllegalStateException e2) {
                mediaPlayer = e2;
                try {
                    if (QLog.isColorLevel()) {
                        str2 = "TRAE";
                    }
                } catch (Exception e3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TRAE", 2, "TraeMediaPlay | Except: " + e3.getLocalizedMessage() + " " + e3.getMessage());
                    }
                }
                try {
                    this.mMediaPlay.release();
                } catch (Exception e4) {
                }
                this.mMediaPlay = null;
                return false;
            } catch (IOException e5) {
                mediaPlayer = e5;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                return false;
            } catch (IllegalArgumentException e6) {
                mediaPlayer = e6;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                return false;
            } catch (SecurityException e7) {
                mediaPlayer = e7;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                return false;
            } finally {
                this.mMediaPlay = null;
            }
            if (this._watchTimer != null) {
                this._watchTimer.cancel();
                this._watchTimer = null;
                this._watchTimertask = null;
            }
            audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            this.mMediaPlay = new MediaPlayer();
            if (this.mMediaPlay != null) {
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                return false;
            }
            this.mMediaPlay.setOnCompletionListener(this);
            this.mMediaPlay.setOnErrorListener(this);
            switch (i) {
                case 0:
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | rsid:" + i2);
                    }
                    openRawResourceFd = this._context.getResources().openRawResourceFd(i2);
                    if (openRawResourceFd == null) {
                        this.mMediaPlay.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                        openRawResourceFd.close();
                        break;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | afd == null rsid:" + i2);
                    }
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    return false;
                case 1:
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | uri:" + uri);
                    }
                    this.mMediaPlay.setDataSource(this._context, uri);
                    break;
                case 2:
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | FilePath:" + str);
                    }
                    this.mMediaPlay.setDataSource(str);
                    break;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "TraeMediaPlay | err datasource:" + i);
                    }
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    break;
            }
            if (this.mMediaPlay == null) {
                return false;
            }
            this._ringMode = z2;
            i5 = 0;
            if (this._ringMode) {
                this._streamType = 2;
                i5 = 1;
            } else {
                this._streamType = 0;
                if (VERSION.SDK_INT >= 11) {
                    i5 = 3;
                }
            }
            this._hasCall = z3;
            if (this._hasCall) {
                this._streamType = i4;
            }
            this.mMediaPlay.setAudioStreamType(this._streamType);
            this.mMediaPlay.prepare();
            this.mMediaPlay.setLooping(z);
            this.mMediaPlay.start();
            this._loop = z;
            if (!this._loop) {
                this._loopCount = 1;
                this._durationMS = -1;
            } else {
                this._loopCount = i3;
                this._durationMS = this._loopCount * this.mMediaPlay.getDuration();
            }
            this._loopCount--;
            if (this._hasCall) {
                audioManager.setMode(i5);
            }
            if (this._durationMS > 0) {
                this._watchTimer = new Timer();
                this._watchTimertask = new 1(this);
                this._watchTimer.schedule(this._watchTimertask, (long) (this._durationMS + 1000));
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeMediaPlay | DurationMS:" + this.mMediaPlay.getDuration() + " loop:" + z);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "TraeMediaPlay | playRing err datasource:" + i + " loop:" + (z ? "Y" : "N") + " :loopCount" + i3);
        }
        return false;
    }

    public void stopRing() {
        if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
        }
        if (this.mMediaPlay != null) {
            if (this.mMediaPlay.isPlaying()) {
                this.mMediaPlay.stop();
            }
            this.mMediaPlay.reset();
            try {
                if (this._watchTimer != null) {
                    this._watchTimer.cancel();
                    this._watchTimer = null;
                    this._watchTimertask = null;
                }
                this.mMediaPlay.release();
            } catch (Exception e) {
            }
            this.mMediaPlay = null;
            this._durationMS = -1;
        }
    }

    public int getStreamType() {
        return this._streamType;
    }

    public int getDuration() {
        return this._durationMS;
    }

    public boolean hasCall() {
        return this._hasCall;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
        if (!this._loop) {
            try {
                if (this._loopCount <= 0) {
                    volumeUndo();
                    if (this.mMediaPlay.isPlaying()) {
                        this.mMediaPlay.stop();
                    }
                    this.mMediaPlay.reset();
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    if (this.mCallback != null) {
                        this.mCallback.a();
                    }
                } else {
                    this.mMediaPlay.start();
                    this._loopCount--;
                }
            } catch (Exception e) {
            }
            AudioDeviceInterface.LogTraceExit();
        } else if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "loop play,continue...");
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + i + " arg2:" + i2);
        try {
            this.mMediaPlay.release();
        } catch (Exception e) {
        }
        this.mMediaPlay = null;
        if (this.mCallback != null) {
            this.mCallback.a();
        }
        AudioDeviceInterface.LogTraceExit();
        return false;
    }

    private void volumeDo() {
        if (this.mMediaPlay != null && this._ringMode && this._streamType != 2) {
            try {
                AudioManager audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                int streamVolume = audioManager.getStreamVolume(this._streamType);
                int streamMaxVolume = audioManager.getStreamMaxVolume(this._streamType);
                int streamVolume2 = audioManager.getStreamVolume(2);
                int streamMaxVolume2 = audioManager.getStreamMaxVolume(2);
                int i = (int) (((((double) streamVolume2) * 1.0d) / ((double) streamMaxVolume2)) * ((double) streamMaxVolume));
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + streamVolume + " maxV:" + streamMaxVolume + " currRV:" + streamVolume2 + " maxRV:" + streamMaxVolume2 + " setV:" + i);
                }
                if (i + 1 < streamMaxVolume) {
                    streamMaxVolume = i + 1;
                }
                audioManager.setStreamVolume(this._streamType, streamMaxVolume, 0);
                this._prevVolume = streamVolume;
            } catch (Exception e) {
            }
        }
    }

    private void volumeUndo() {
        if (this.mMediaPlay != null && this._ringMode && this._streamType != 2 && this._prevVolume != -1) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
                }
                ((AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setStreamVolume(this._streamType, this._prevVolume, 0);
            } catch (Exception e) {
            }
        }
    }
}
