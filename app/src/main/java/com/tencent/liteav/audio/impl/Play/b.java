package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.f.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class b extends TXCAudioBasePlayController {
    public static final String a = ("AudioCenter:" + b.class.getSimpleName());
    private a b;
    private a c;

    public b(Context context) {
        super(context);
    }

    protected void finalize() {
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
    }

    public static void a(Context context, int i) {
        d.a().a(context, i);
    }

    public long getCacheDuration() {
        if (this.mIsHWAcceleration) {
            return this.b.a() + nativeGetCacheDuration(this.mJitterBuffer);
        }
        return nativeGetCacheDuration(this.mJitterBuffer);
    }

    public int startPlay() {
        TXCLog.i(a, "start play audio!");
        if (this.mIsPlaying) {
            TXCLog.e(a, "repeat start play audio, ignore it!");
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        }
        if (this.mIsHWAcceleration) {
            this.b = new a();
            this.b.a(new WeakReference(this));
        }
        this.mIsPlaying = true;
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
                d.a().c();
            }
            if (this.b != null) {
                this.b.b();
                this.b = null;
            }
            this.c = null;
            TXCLog.i(a, "finish stop play audio!");
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        }
        TXCLog.e(a, "repeat stop play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public int playData(a aVar) {
        if (this.mIsHWAcceleration) {
            return b(aVar);
        }
        return a(aVar);
    }

    private int a(a aVar) {
        if (aVar == null) {
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        int i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (com.tencent.liteav.basic.a.a.m == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.e(a, "soft dec, not support audio type , packet type : " + aVar.d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
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
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.a.a(aVar.f));
            }
            if (this.mJitterBuffer != 0) {
                nativeAddData(this.mJitterBuffer, aVar.f, aVar.d, aVar.e);
                a aVar2;
                if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                    this.c = new a();
                    this.c.a = nativeGetPlaySamplerate(this.mJitterBuffer);
                    this.c.b = nativeGetPlayChannel(this.mJitterBuffer);
                    this.c.c = c.c;
                    this.c.d = com.tencent.liteav.basic.a.a.k;
                    aVar2 = new a();
                    aVar2.a = 48000;
                    aVar2.b = 1;
                    aVar2.c = 16;
                    aVar2.d = com.tencent.liteav.basic.a.a.k;
                    onPlayAudioInfoChanged(this.c, aVar2);
                } else if (com.tencent.liteav.basic.a.a.m == aVar.d && this.c == null) {
                    this.c = new a();
                    this.c.a = nativeGetPlaySamplerate(this.mJitterBuffer);
                    this.c.b = nativeGetPlayChannel(this.mJitterBuffer);
                    this.c.c = c.c;
                    this.c.d = com.tencent.liteav.basic.a.a.k;
                    aVar2 = new a();
                    aVar2.a = 48000;
                    aVar2.b = 1;
                    aVar2.c = 16;
                    aVar2.d = com.tencent.liteav.basic.a.a.k;
                    onPlayAudioInfoChanged(this.c, aVar2);
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

    private int b(a aVar) {
        if (aVar == null) {
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        int i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (com.tencent.liteav.basic.a.a.m == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.e(a, "hw dec, not support audio type , packet type : " + aVar.d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
        }
        if (this.mIsPlaying) {
            if (this.mJitterBuffer == 0) {
                this.mJitterBuffer = nativeCreateJitterBuffer(true, this);
                if (this.mJitterBuffer != 0) {
                    nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                    nativeSetMute(this.mJitterBuffer, this.mIsMute);
                    nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                    nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsRealTimePlay);
                    nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                    nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                } else {
                    TXCLog.e(a, "hw dec, create jitterbuffer failed!!");
                }
                TXCLog.e(a, "hw dec, create jitterbuffer with id " + this.mJitterBuffer);
            }
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.a.a(aVar.f));
            }
            if (this.b != null) {
                this.b.a(aVar);
            }
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        }
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
        TXCLog.w(a, "hw dec, invalid state. player not started yet!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
    }

    public void onPlayAudioInfoChanged(a aVar, a aVar2) {
        if (this.c == null) {
            this.c = aVar;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
        if (!nativeIsTracksEmpty()) {
            d.a().b();
        }
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        super.onPlayPcmData(bArr, j);
        if (this.mJitterBuffer != 0 && this.mIsHWAcceleration) {
            nativeAddData(this.mJitterBuffer, bArr, com.tencent.liteav.basic.a.a.n, j);
        }
    }
}
