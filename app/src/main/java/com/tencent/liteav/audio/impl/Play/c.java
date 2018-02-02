package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.f.a;
import com.tencent.liteav.basic.log.TXCLog;

public class c extends TXCAudioBasePlayController implements d {
    private static final String a = ("AudioCenter:" + c.class.getSimpleName());
    private a b;

    public c(Context context) {
        super(context);
    }

    protected void finalize() {
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
    }

    public static void a(Context context, int i) {
        TXCTraeJNI.setContext(context);
        TXCTraeJNI.nativeSetAudioMode(i);
    }

    public int startPlay() {
        TXCLog.i(a, "start play audio!");
        if (this.mIsPlaying) {
            TXCLog.e(a, "repeat start play audio, ignore it!");
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        }
        super.startPlay();
        TXCLog.i(a, "finish start play audio!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int stopPlay() {
        TXCLog.i(a, "stop play audio!");
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            if (nativeIsTracksEmpty()) {
                TXCTraeJNI.nativeTraeStopPlay();
            }
            this.b = null;
            TXCLog.i(a, "finish stop play audio!");
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        }
        TXCLog.e(a, "repeat stop play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public int playData(a aVar) {
        if (aVar == null) {
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d || com.tencent.liteav.basic.a.a.m == aVar.d) {
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + aVar.f);
            }
            if (this.mIsPlaying) {
                if (this.mJitterBuffer == 0) {
                    this.mJitterBuffer = nativeCreateJitterBuffer(false, this);
                    if (this.mJitterBuffer != 0) {
                        nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                        nativeSetMute(this.mJitterBuffer, this.mIsMute);
                        nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                        nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsRealTimePlay);
                        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                        nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                    } else {
                        TXCLog.e(a, "soft dec, create jitterbuffer failed!!");
                    }
                    TXCLog.e(a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
                }
                if (this.mJitterBuffer != 0) {
                    nativeAddData(this.mJitterBuffer, aVar.f, aVar.d, aVar.e);
                    a aVar2;
                    if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                        this.b = new a();
                        this.b.a = nativeGetPlaySamplerate(this.mJitterBuffer);
                        this.b.b = nativeGetPlayChannel(this.mJitterBuffer);
                        this.b.c = com.tencent.liteav.audio.c.c;
                        this.b.d = com.tencent.liteav.basic.a.a.k;
                        aVar2 = new a();
                        aVar2.a = 48000;
                        aVar2.b = 1;
                        aVar2.c = 16;
                        aVar2.d = com.tencent.liteav.basic.a.a.k;
                        onPlayAudioInfoChanged(this.b, aVar2);
                    } else if (com.tencent.liteav.basic.a.a.m == aVar.d && this.b == null) {
                        this.b = new a();
                        this.b.a = nativeGetPlaySamplerate(this.mJitterBuffer);
                        this.b.b = nativeGetPlayChannel(this.mJitterBuffer);
                        this.b.c = com.tencent.liteav.audio.c.c;
                        this.b.d = com.tencent.liteav.basic.a.a.k;
                        aVar2 = new a();
                        aVar2.a = 48000;
                        aVar2.b = 1;
                        aVar2.c = 16;
                        aVar2.d = com.tencent.liteav.basic.a.a.k;
                        onPlayAudioInfoChanged(this.b, aVar2);
                    }
                    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                }
                onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
                TXCLog.e(a, "soft dec, jitterbuffer not created yet!!");
                return TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
            }
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
            TXCLog.w(a, "sotf dec, invalid state. player not started yet!");
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        }
        TXCLog.e(a, "soft dec, not support audio type , packet type : " + aVar.d);
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
    }

    public void onPlayAudioInfoChanged(a aVar, a aVar2) {
        if (this.b == null) {
            this.b = aVar;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
        if (!nativeIsTracksEmpty()) {
            TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
            TXCTraeJNI.nativeTraeStartPlay(this.mContext);
        }
    }
}
