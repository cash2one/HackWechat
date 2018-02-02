package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.b;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.f.a;
import com.tencent.liteav.basic.log.TXCLog;

public class TXCAudioBasePlayController implements d {
    private static final String TAG = ("AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName());
    protected float mAutoAdjustMaxCache = b.d;
    protected float mAutoAdjustMinCache = b.e;
    protected float mCacheTime = b.b;
    protected Context mContext;
    protected boolean mIsAutoAdjustCache = b.c;
    protected boolean mIsHWAcceleration = false;
    protected boolean mIsMute = b.f;
    protected volatile boolean mIsPlaying = false;
    protected boolean mIsRealTimePlay = false;
    protected long mJitterBuffer = 0;
    protected d mListener;

    public static native byte[] nativeGetMixedTracksData(int i);

    public static native void nativeSetTempPath(String str);

    protected native void nativeAddData(long j, byte[] bArr, int i, long j2);

    protected native long nativeCreateJitterBuffer(boolean z, TXCAudioBasePlayController tXCAudioBasePlayController);

    protected native void nativeDestoryJitterBuffer(long j);

    protected native void nativeEnableAutoAdjustCache(long j, boolean z);

    protected native void nativeEnableRealTimePlay(long j, boolean z);

    protected native long nativeGetCacheDuration(long j);

    protected native long nativeGetCurPlayPTS(long j);

    protected native TXAudioJitterBufferReportInfo nativeGetLoadingInfo(long j);

    protected native long nativeGetNetRecvTS(long j);

    protected native int nativeGetPlayChannel(long j);

    protected native int nativeGetPlaySamplerate(long j);

    protected native float nativeGetPlayTS(long j);

    protected native int nativeGetRecvJitter(long j);

    protected native boolean nativeIsTracksEmpty();

    protected native void nativeSetAutoAdjustMaxCache(long j, float f);

    protected native void nativeSetAutoAdjustMinCache(long j, float f);

    protected native void nativeSetCacheTime(long j, float f);

    protected native void nativeSetMute(long j, boolean z);

    static {
        nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public TXCAudioBasePlayController(Context context) {
        this.mContext = context;
    }

    public static void setAudioMode(Context context, int i) {
        b.a(context, i);
        c.a(context, i);
    }

    public synchronized void setListener(d dVar) {
        this.mListener = dVar;
    }

    public void setCacheTime(float f) {
        if (this.mCacheTime != f) {
            TXCLog.i(TAG, "set cache time to " + f);
            nativeSetCacheTime(this.mJitterBuffer, f);
            this.mCacheTime = f;
        }
    }

    public void enableAutojustCache(boolean z) {
        if (this.mIsAutoAdjustCache != z) {
            TXCLog.i(TAG, "set auto adjust cache to " + z);
            nativeEnableAutoAdjustCache(this.mJitterBuffer, z);
            this.mIsAutoAdjustCache = z;
        }
    }

    public void setAutoAdjustMaxCache(float f) {
        if (this.mAutoAdjustMaxCache != f) {
            TXCLog.i(TAG, "set auto adjust max cache to " + f);
            nativeSetAutoAdjustMaxCache(this.mJitterBuffer, f);
            this.mAutoAdjustMaxCache = f;
        }
    }

    public void setAutoAdjustMinCache(float f) {
        if (this.mAutoAdjustMinCache != f) {
            TXCLog.i(TAG, "set auto adjust min cache to " + f);
            nativeSetAutoAdjustMinCache(this.mJitterBuffer, f);
            this.mAutoAdjustMinCache = f;
        }
    }

    public void enableHWAcceleration(boolean z) {
        TXCLog.i(TAG, "set hw acceleration to " + z);
        this.mIsHWAcceleration = z;
    }

    public long getCacheDuration() {
        return nativeGetCacheDuration(this.mJitterBuffer);
    }

    public void enableRealTimePlay(boolean z) {
        if (z != this.mIsRealTimePlay) {
            TXCLog.i(TAG, "set real-time play to " + z);
            nativeEnableRealTimePlay(this.mJitterBuffer, z);
            this.mIsRealTimePlay = z;
        }
    }

    public TXAudioJitterBufferReportInfo getReportInfo() {
        if (!this.mIsPlaying || this.mJitterBuffer == 0) {
            return null;
        }
        return nativeGetLoadingInfo(this.mJitterBuffer);
    }

    public long getCurPlayTS() {
        return nativeGetCurPlayPTS(this.mJitterBuffer);
    }

    public int getRecvJitter() {
        return nativeGetRecvJitter(this.mJitterBuffer);
    }

    public long getCurRecvTS() {
        return nativeGetNetRecvTS(this.mJitterBuffer);
    }

    public float getPlaySpeed() {
        return nativeGetPlayTS(this.mJitterBuffer);
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public int startPlay() {
        this.mIsPlaying = true;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int playData(a aVar) {
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int stopPlay() {
        this.mIsPlaying = false;
        this.mCacheTime = b.b;
        this.mIsAutoAdjustCache = b.c;
        this.mAutoAdjustMaxCache = b.d;
        this.mAutoAdjustMinCache = b.e;
        this.mIsRealTimePlay = false;
        this.mIsHWAcceleration = false;
        this.mIsMute = b.f;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public void setMute(boolean z) {
        if (z != this.mIsMute) {
            nativeSetMute(this.mJitterBuffer, z);
        }
        TXCLog.i(TAG, "set mute to " + z);
        this.mIsMute = z;
    }

    public synchronized void onPlayPcmData(byte[] bArr, long j) {
        if (this.mListener != null) {
            this.mListener.onPlayPcmData(bArr, j);
        }
    }

    public synchronized void onPlayError(int i, String str) {
        if (this.mListener != null) {
            this.mListener.onPlayError(i, str);
        }
    }

    public synchronized void onPlayJitterStateNotify(int i) {
        TXCLog.e(TAG, "onPlayJitterStateNotify  cur state " + i);
        if (this.mListener != null) {
            this.mListener.onPlayJitterStateNotify(i);
        }
    }

    public synchronized void onPlayAudioInfoChanged(a aVar, a aVar2) {
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
    }
}
