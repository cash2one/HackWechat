package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;

public class g extends c {
    public int startRecord(Context context) {
        TXCLog.i("AudioCenter:TXCAudioSysRecordController", "trae startRecord");
        super.startRecord(context);
        TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
        TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
        TXCTraeJNI.nativeTraeStartRecord(context, this.mSampleRate, this.mChannels, this.mBits);
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((e) this.mWeakRecordListener.get()).a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        return 0;
    }

    public int stopRecord() {
        TXCLog.i("AudioCenter:TXCAudioSysRecordController", "trae stopRecord");
        TXCTraeJNI.nativeTraeStopRecord(true);
        TXCTraeJNI.setTraeRecordListener(null);
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public boolean isRecording() {
        return TXCTraeJNI.nativeTraeIsRecording();
    }

    public void setReverbType(int i) {
        super.setReverbType(i);
        TXCTraeJNI.nativeTraeSetRecordReverb(i);
    }

    public void setVolume(float f) {
        super.setVolume(f);
        TXCTraeJNI.nativeTraeSetVolume(f);
    }

    public void setMute(boolean z) {
        super.setMute(z);
        TXCTraeJNI.nativeTraeSetRecordMute(z);
        this.mIsMute = z;
    }
}
