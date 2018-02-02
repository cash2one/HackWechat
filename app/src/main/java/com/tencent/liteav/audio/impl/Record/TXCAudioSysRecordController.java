package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.audio.impl.d;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioSysRecordController extends c implements h, d {
    private static final String TAG = ("AudioCenter:" + TXCAudioSysRecordController.class.getSimpleName());
    private byte[] mBuf = null;
    private d mCustomRecord = null;
    private long mEffectorObj = 0;
    private e mHWEcoder = null;
    private b mHeadsetMgr = null;
    private long mLastPTS = 0;
    private int mPosition = 0;
    private int mRecordSampleRate = a.e;
    private long mSoftEncObj = 0;

    private native void nativeAddEffect(long j, byte[] bArr);

    private native void nativeAddEffectAndSoftEnc(long j, long j2, byte[] bArr);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native long nativeCreateSoftEncoder(int i, int i2, int i3);

    private native void nativeDestorySoftEncoder(long j);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native void nativeMixBGM(long j, boolean z);

    private native byte[] nativeReadOneEncFrame();

    private native byte[] nativeReadOneFrame(long j, int i);

    private native void nativeSetInputInfo(long j, int i, int i2, int i3);

    private native void nativeSetNoiseSuppression(long j, int i);

    private native void nativeSetReverbParam(long j, int i, float f);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetVolume(long j, float f);

    static {
        com.tencent.liteav.basic.util.a.d();
    }

    public int startRecord(Context context) {
        TXCLog.i(TAG, JsApiStartRecordVoice.NAME);
        super.startRecord(context);
        if (this.mIsCustomRecord) {
            setNoiseSuppression(-1);
            this.mRecordSampleRate = this.mSampleRate;
            this.mCustomRecord = new d();
            this.mCustomRecord.a(this);
            this.mCustomRecord.a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits);
        } else {
            if (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                if (this.mSampleRate > com.tencent.liteav.basic.e.b.a().g()) {
                    this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().h();
                } else {
                    this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().g();
                }
                if (this.mRecordSampleRate == 0) {
                    this.mRecordSampleRate = 16000;
                }
            } else {
                this.mRecordSampleRate = this.mSampleRate;
            }
            f.a().a(this);
            f.a().a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((e) this.mWeakRecordListener.get()).a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM ? "SYSTEM-AEC," : "NO-AEC,") + "采样率(" + this.mRecordSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        return 0;
    }

    public int stopRecord() {
        TXCLog.i(TAG, JsApiStopRecordVoice.NAME);
        if (this.mCustomRecord != null) {
            this.mCustomRecord.c();
            this.mCustomRecord = null;
        }
        f.a().b();
        if (this.mHeadsetMgr != null) {
            this.mHeadsetMgr.a();
            this.mHeadsetMgr = null;
        }
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
        if (this.mCustomRecord != null) {
            this.mCustomRecord.a(bArr);
        }
    }

    public boolean isRecording() {
        if (this.mCustomRecord != null) {
            return this.mCustomRecord.d();
        }
        return f.a().c();
    }

    public synchronized void setEarphoneOn(boolean z) {
        super.setEarphoneOn(z);
        if (this.mEffectorObj > 0) {
            boolean z2 = false;
            if (z || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                z2 = true;
            }
            nativeMixBGM(this.mEffectorObj, z2);
        }
    }

    public synchronized void setReverbType(int i) {
        super.setReverbType(i);
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
    }

    public synchronized void setNoiseSuppression(int i) {
        super.setNoiseSuppression(i);
        if (this.mEffectorObj > 0) {
            nativeSetNoiseSuppression(this.mEffectorObj, i);
        }
    }

    public void setVolume(float f) {
        super.setVolume(f);
        if (this.mEffectorObj != 0) {
            nativeSetVolume(this.mEffectorObj, f);
        }
    }

    public synchronized void setReverbParam(int i, float f) {
        super.setReverbParam(i, f);
        if (this.mEffectorObj != 0) {
            nativeSetReverbParam(this.mEffectorObj, i, f);
        }
    }

    public synchronized void onAudioRecordStart() {
        TXCLog.i(TAG, "sys audio record start");
        uninitEffectAndEnc();
        initEffectAndEnc();
    }

    public synchronized void onAudioRecordStop() {
        TXCLog.i(TAG, "sys audio record stop");
        f.a().a(null);
        uninitEffectAndEnc();
    }

    public synchronized void onAudioRecordError(int i, String str) {
        TXCLog.e(TAG, "sys audio record error: " + i + ", " + str);
        f.a().a(null);
        uninitEffectAndEnc();
    }

    public synchronized void onAudioRecordPCM(byte[] bArr, int i, long j) {
        if (this.mEffectorObj > 0) {
            long j2;
            if (this.mIsMute) {
                Arrays.fill(bArr, (byte) 0);
            }
            if (this.mLastPTS >= j) {
                j2 = this.mLastPTS + 2;
            } else {
                j2 = j;
            }
            long j3;
            byte[] nativeReadOneEncFrame;
            e listener;
            if (this.mHWEcoder == null) {
                nativeAddEffectAndSoftEnc(this.mEffectorObj, this.mSoftEncObj, bArr);
                j3 = j2;
                while (true) {
                    nativeReadOneEncFrame = nativeReadOneEncFrame();
                    if (nativeReadOneEncFrame == null) {
                        break;
                    }
                    this.mLastPTS = j3;
                    listener = getListener();
                    if (listener != null) {
                        listener.b(nativeReadOneEncFrame, j3, this.mSampleRate, this.mChannels, this.mBits);
                    }
                    j3 += (long) (1024000 / this.mSampleRate);
                }
            } else {
                nativeAddEffect(this.mEffectorObj, bArr);
                j3 = j2;
                do {
                    nativeReadOneEncFrame = nativeReadOneFrame(this.mEffectorObj, ((this.mChannels * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.mBits) / 8);
                    if (nativeReadOneEncFrame != null) {
                        this.mLastPTS = j3;
                        if (this.mHWEcoder != null) {
                            doHWEncode(nativeReadOneEncFrame, j3);
                        } else {
                            listener = getListener();
                            if (listener != null) {
                                listener.b(nativeReadOneEncFrame, j3, this.mSampleRate, this.mChannels, this.mBits);
                            }
                        }
                    }
                    j3 += (long) (1024000 / this.mSampleRate);
                } while (nativeReadOneEncFrame != null);
            }
        } else {
            TXCLog.e(TAG, "effectorObj is null");
        }
    }

    private void initEffectAndEnc() {
        boolean z;
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        if (this.mSampleRate != this.mRecordSampleRate) {
            nativeSetInputInfo(this.mEffectorObj, this.mRecordSampleRate, this.mChannels, this.mBits);
        }
        if (this.mIsEarphoneOn || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
            z = true;
        } else {
            z = false;
        }
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetNoiseSuppression(this.mEffectorObj, this.mNSMode);
        if (this.mEnableHWEncoder) {
            this.mHWEcoder = new e();
            e listener = getListener();
            this.mHWEcoder.a(TXEAudioDef.TXE_AUDIO_TYPE_AAC, this.mSampleRate, this.mChannels, this.mBits, listener != null ? new WeakReference(listener) : null);
            this.mBuf = new byte[(((this.mChannels * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.mBits) / 8)];
            this.mPosition = 0;
        } else {
            this.mSoftEncObj = nativeCreateSoftEncoder(this.mSampleRate, this.mChannels, this.mBits);
        }
        this.mLastPTS = 0;
        TXCLog.i(TAG, "初始化直播录制:录制模式 = " + (this.mCustomRecord == null ? "麦克风录制" : "用户自定义录制") + ", 录制采样率 = " + this.mRecordSampleRate + ", 输出采样率 = " + this.mSampleRate + ", 是否混音 = " + z + ", 混响模式 = " + this.mReverbType + ", 是否启动硬编码 = " + this.mEnableHWEncoder + ", 噪声抑制mode = " + this.mNSMode);
        this.mHeadsetMgr = new b(this.mContext);
        this.mHeadsetMgr.a(this);
    }

    private void uninitEffectAndEnc() {
        if (this.mEffectorObj != 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
        if (this.mSoftEncObj != 0) {
            nativeDestorySoftEncoder(this.mSoftEncObj);
            this.mSoftEncObj = 0;
        }
        if (this.mHWEcoder != null) {
            this.mHWEcoder.a();
            this.mHWEcoder = null;
        }
    }

    private void doHWEncode(byte[] bArr, long j) {
        if (bArr == null || bArr.length == 0 || this.mBuf == null || this.mHWEcoder == null) {
            TXCLog.e(TAG, "doHWEncode failed! data = " + bArr + ", buf = " + this.mBuf + ", encoder = " + this.mHWEcoder);
            return;
        }
        int length = this.mBuf.length - this.mPosition;
        if (length > bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(bArr, 0, this.mBuf, this.mPosition, length);
        this.mPosition = length + this.mPosition;
        if (this.mPosition == this.mBuf.length) {
            this.mPosition = 0;
            this.mHWEcoder.a(this.mBuf, j);
        }
    }

    private void onRecordPcmData(byte[] bArr) {
        e listener = getListener();
        if (listener != null) {
            listener.a(bArr, TXCTimeUtil.getTimeTick(), this.mSampleRate, this.mChannels, this.mBits);
        }
    }

    public void OnHeadsetState(boolean z) {
        setEarphoneOn(z);
    }
}
