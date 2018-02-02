package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder implements h {
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    static TXCAudioUGCRecorder instance = new TXCAudioUGCRecorder();
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    private a mBGMRecorder = null;
    protected int mBits = com.tencent.liteav.basic.a.a.h;
    protected int mChannels = com.tencent.liteav.basic.a.a.f;
    protected Context mContext;
    private boolean mCurBGMRecordFlag = false;
    private long mEffectorObj = 0;
    private boolean mEnableBGMRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    private boolean mIsPause = false;
    private long mLastPTS = 0;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = com.tencent.liteav.basic.a.a.e;
    private float mSpeedRate = 1.0f;
    private float mVolume = 1.0f;
    private WeakReference<e> mWeakRecordListener;

    private native void nativeClearCache(long j);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native long nativeGetPcmCacheLen(long j);

    private native void nativeMixBGM(long j, boolean z);

    private native void nativeProcess(long j, byte[] bArr, int i);

    private native byte[] nativeReadOneFrame(long j);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetSpeedRate(long j, float f);

    private native void nativeSetVolume(long j, float f);

    static {
        com.tencent.liteav.basic.util.a.d();
    }

    public static TXCAudioUGCRecorder getInstance() {
        return instance;
    }

    private TXCAudioUGCRecorder() {
    }

    public int startRecord(Context context) {
        TXCLog.i(TAG, JsApiStartRecordVoice.NAME);
        if (isRecording()) {
            if (this.mEnableBGMRecord == this.mCurBGMRecordFlag) {
                TXCLog.e(TAG, "startRecord failed! recorder is still running!");
                return -1;
            }
            TXCLog.e(TAG, "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
            stopRecord();
            enableBGMRecord(!this.mCurBGMRecordFlag);
        }
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        initEffector();
        if (this.mEnableBGMRecord) {
            TXCLog.i(TAG, "录制BGM");
            this.mCurBGMRecordFlag = true;
            this.mBGMRecorder = new a();
            this.mBGMRecorder.a(this);
            setEarphoneOn(true);
            this.mBGMRecorder.a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
            return 0;
        }
        TXCLog.i(TAG, "录制人声");
        this.mCurBGMRecordFlag = false;
        setEarphoneOn(false);
        f.a().a(this);
        f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        return 0;
    }

    public int stopRecord() {
        TXCLog.i(TAG, JsApiStopRecordVoice.NAME);
        if (this.mBGMRecorder != null) {
            this.mBGMRecorder.a();
            this.mBGMRecorder = null;
        }
        f.a().b();
        enableBGMRecord(false);
        this.mIsPause = false;
        uninitEffector();
        return 0;
    }

    public void pause() {
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        if (!this.mEnableBGMRecord && isRecording()) {
            TXCLog.i(TAG, "停止系统录音");
            f.a().b();
        }
    }

    public void resume() {
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        if (!this.mEnableBGMRecord && !isRecording()) {
            TXCLog.i(TAG, "恢复系统录音");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            f.a().a(this);
            f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
    }

    public synchronized void setListener(e eVar) {
        if (eVar == null) {
            this.mWeakRecordListener = null;
        } else {
            this.mWeakRecordListener = new WeakReference(eVar);
        }
    }

    public synchronized e getListener() {
        e eVar;
        if (this.mWeakRecordListener != null) {
            eVar = (e) this.mWeakRecordListener.get();
        } else {
            eVar = null;
        }
        return eVar;
    }

    public void setChannels(int i) {
        TXCLog.i(TAG, "setChannels: " + i);
        this.mChannels = i;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public void setSampleRate(int i) {
        TXCLog.i(TAG, "setSampleRate: " + i);
        this.mSampleRate = i;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public synchronized void setReverbType(int i) {
        TXCLog.i(TAG, "setReverbType: " + i);
        this.mReverbType = i;
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
    }

    public void setAECType(int i, Context context) {
        TXCLog.i(TAG, "setAECType: " + i);
        this.mAECType = i;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public void setMute(boolean z) {
        TXCLog.i(TAG, "setMute: " + z);
        this.mIsMute = z;
    }

    public void enableBGMRecord(boolean z) {
        TXCLog.i(TAG, "enableBGMRecord: " + z);
        this.mEnableBGMRecord = z;
    }

    public synchronized void setEarphoneOn(boolean z) {
        TXCLog.i(TAG, "setEarphoneOn: " + z);
        this.mIsEarphoneOn = z;
        if (this.mEffectorObj > 0) {
            boolean z2 = false;
            if (z || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                z2 = true;
            }
            nativeMixBGM(this.mEffectorObj, z2);
        }
    }

    public boolean isRecording() {
        if (this.mBGMRecorder != null) {
            return this.mBGMRecorder.b();
        }
        return f.a().c();
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public synchronized long getPcmCacheLen() {
        long j = 0;
        synchronized (this) {
            if (this.mEffectorObj > 0) {
                j = nativeGetPcmCacheLen(this.mEffectorObj);
            }
        }
        return j;
    }

    public synchronized void setVolume(float f) {
        TXCLog.i(TAG, "setVolume: " + f);
        this.mVolume = f;
        if (this.mEffectorObj > 0) {
            nativeSetVolume(this.mEffectorObj, f);
        }
    }

    public synchronized void setSpeedRate(float f) {
        TXCLog.i(TAG, "setSpeedRate: " + f);
        this.mSpeedRate = f;
        if (this.mEffectorObj > 0) {
            nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
        }
    }

    public synchronized void clearCache() {
        TXCLog.i(TAG, "clearCache");
        if (this.mEffectorObj > 0) {
            nativeClearCache(this.mEffectorObj);
        }
    }

    public void onAudioRecordStart() {
        TXCLog.i(TAG, "sys audio record start");
    }

    public void onAudioRecordStop() {
        TXCLog.i(TAG, "sys audio record stop");
        f.a().a(null);
    }

    public void onAudioRecordError(int i, String str) {
        TXCLog.e(TAG, "sys audio record error: " + i + ", " + str);
        f.a().a(null);
        e listener = getListener();
        if (listener != null) {
            listener.a(i, str);
        }
    }

    public void onAudioRecordPCM(byte[] bArr, int i, long j) {
        if (!this.mIsPause) {
            if (this.mEffectorObj > 0) {
                if (this.mIsMute) {
                    Arrays.fill(bArr, (byte) 0);
                }
                if (this.mLastPTS >= j) {
                    j = this.mLastPTS + 2;
                }
                synchronized (this) {
                    nativeProcess(this.mEffectorObj, bArr, i);
                }
                long j2 = j;
                byte[] nativeReadOneFrame;
                do {
                    synchronized (this) {
                        nativeReadOneFrame = nativeReadOneFrame(this.mEffectorObj);
                    }
                    if (nativeReadOneFrame != null) {
                        this.mLastPTS = j2;
                        e listener = getListener();
                        if (listener != null) {
                            listener.b(nativeReadOneFrame, j2, this.mSampleRate, this.mChannels, this.mBits);
                        }
                    }
                    j2 = (long) (((float) j2) + (((float) (1024000 / this.mSampleRate)) * this.mSpeedRate));
                } while (nativeReadOneFrame != null);
                return;
            }
            TXCLog.e(TAG, "effectorObj is null");
        }
    }

    private synchronized void initEffector() {
        uninitEffector();
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        boolean z = false;
        if (this.mIsEarphoneOn || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
            z = true;
        }
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetVolume(this.mEffectorObj, this.mVolume);
        nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
        nativeEnableEncoder(this.mEffectorObj, true);
        this.mLastPTS = 0;
    }

    private synchronized void uninitEffector() {
        if (this.mEffectorObj > 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
    }
}
