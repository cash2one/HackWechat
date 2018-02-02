package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public abstract class c {
    private static final String TAG = ("AudioCenter:" + c.class.getSimpleName());
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    protected int mBits = a.h;
    protected int mChannels = a.f;
    protected Context mContext;
    protected boolean mEnableHWEncoder = false;
    protected boolean mIsCustomRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    protected int mNSMode = -1;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = a.e;
    protected float mVolume = 1.0f;
    protected WeakReference<e> mWeakRecordListener;

    public abstract boolean isRecording();

    public abstract void sendCustomPCMData(byte[] bArr);

    public abstract int stopRecord();

    public synchronized void setListener(e eVar) {
        TXCLog.i(TAG, "setListener:" + eVar);
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

    public void setSamplerate(int i) {
        TXCLog.i(TAG, "setSampleRate: " + i);
        this.mSampleRate = i;
    }

    public void setChannels(int i) {
        TXCLog.i(TAG, "setChannels: " + i);
        this.mChannels = i;
    }

    public void setReverbType(int i) {
        TXCLog.i(TAG, "setReverbType: " + i);
        this.mReverbType = i;
    }

    public void setAECType(int i) {
        TXCLog.i(TAG, "setAECType: " + i);
        this.mAECType = i;
    }

    public void enableHWEncoder(boolean z) {
        TXCLog.i(TAG, "enableHWEncoder: " + z);
        this.mEnableHWEncoder = z;
    }

    public void setMute(boolean z) {
        TXCLog.i(TAG, "setMute: " + z);
        this.mIsMute = z;
    }

    public void setVolume(float f) {
        if (f <= 0.2f) {
            TXCLog.w(TAG, "setVolume, warning volume too low : " + f);
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mVolume = f;
    }

    public void setEarphoneOn(boolean z) {
        TXCLog.i(TAG, "setEarphoneOn: " + z);
        this.mIsEarphoneOn = z;
    }

    public void setNoiseSuppression(int i) {
        TXCLog.i(TAG, "setNoiseSuppression: " + i);
        this.mNSMode = i;
    }

    public int startRecord(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        return 0;
    }

    public void setIsCustomRecord(boolean z) {
        TXCLog.i(TAG, "setIsCustomRecord: " + z);
        this.mIsCustomRecord = z;
    }

    public void setReverbParam(int i, float f) {
    }
}
