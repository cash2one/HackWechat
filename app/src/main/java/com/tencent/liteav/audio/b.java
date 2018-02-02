package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.a;
import com.tencent.liteav.audio.impl.c;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;

public class b implements e {
    public static final int a = TXEAudioDef.TXE_AEC_NONE;
    public static float b = 5.0f;
    public static boolean c = true;
    public static float d = 5.0f;
    public static float e = 1.0f;
    public static boolean f = false;
    private static final String g = ("AudioCenter:" + b.class.getSimpleName());
    private TXCAudioBasePlayController h = null;
    private d i;
    private int j = a;
    private float k = b;
    private boolean l = c;
    private float m = d;
    private float n = e;
    private boolean o = false;
    private boolean p = false;
    private boolean q = f;
    private Context r;

    public synchronized int a(Context context) {
        int i;
        if (context == null) {
            TXCLog.e(g, "invalid param, start play failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        } else {
            if (a.c(this.j) != TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK) {
                TXCLog.w(g, "start player failed, with aec type " + this.j + ", invalid aec recorder has started!");
            }
            if (this.h == null || !this.h.isPlaying()) {
                this.r = context;
                c.a().a(this.r);
                c.a().a(this);
                if (this.h == null) {
                    if (this.j == TXEAudioDef.TXE_AEC_TRAE) {
                        this.h = new com.tencent.liteav.audio.impl.Play.c(context.getApplicationContext());
                    } else {
                        this.h = new com.tencent.liteav.audio.impl.Play.b(context.getApplicationContext());
                    }
                }
                if (this.h != null) {
                    a(this.j, this.r);
                    a(this.i);
                    a(this.k);
                    a(this.l);
                    b(this.m);
                    c(this.n);
                    c(this.o);
                    b(this.p);
                    d(this.q);
                    i = this.h.startPlay();
                } else {
                    TXCLog.e(g, "start play failed! controller is null!");
                    i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
                }
            } else {
                TXCLog.e(g, "play has started, can not start again!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            }
        }
        return i;
    }

    public synchronized int a() {
        int i;
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        this.i = null;
        this.k = b;
        this.l = c;
        this.m = d;
        this.n = e;
        this.o = false;
        this.p = false;
        this.q = f;
        this.r = null;
        if (this.h != null) {
            i = this.h.stopPlay();
            this.h = null;
        }
        c.a().b(this);
        return i;
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
        } else if (com.tencent.liteav.basic.e.b.a().f()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
        } else {
            a.a(com.tencent.liteav.basic.e.b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
        }
    }

    private void a(int i, Context context) {
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            TXCLog.i(g, "set aec type to " + i + ", cur type " + this.j);
            this.j = i;
            return;
        }
        TXCLog.e(g, "set aec type failed, check trae library failed!!");
    }

    public synchronized int a(com.tencent.liteav.basic.f.a aVar) {
        int i;
        if (this.h == null) {
            TXCLog.e(g, "play audio failed, controller not created yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        } else {
            i = this.h.playData(aVar);
        }
        return i;
    }

    public void a(d dVar) {
        this.i = dVar;
        if (this.h != null) {
            this.h.setListener(dVar);
        }
    }

    public void a(float f) {
        this.k = f;
        if (this.h != null) {
            this.h.setCacheTime(f);
        }
    }

    public void a(boolean z) {
        this.l = z;
        if (this.h != null) {
            this.h.enableAutojustCache(z);
        }
    }

    public void b(float f) {
        this.m = f;
        if (this.h != null) {
            this.h.setAutoAdjustMaxCache(f);
        }
    }

    public void c(float f) {
        this.n = f;
        if (this.h != null) {
            this.h.setAutoAdjustMinCache(f);
        }
    }

    public synchronized long b() {
        long cacheDuration;
        if (this.h != null) {
            cacheDuration = this.h.getCacheDuration();
        } else {
            cacheDuration = 0;
        }
        return cacheDuration;
    }

    public synchronized long c() {
        long curPlayTS;
        if (this.h != null) {
            curPlayTS = this.h.getCurPlayTS();
        } else {
            curPlayTS = 0;
        }
        return curPlayTS;
    }

    public synchronized int d() {
        int recvJitter;
        if (this.h != null) {
            recvJitter = this.h.getRecvJitter();
        } else {
            recvJitter = 0;
        }
        return recvJitter;
    }

    public synchronized long e() {
        long curRecvTS;
        if (this.h != null) {
            curRecvTS = this.h.getCurRecvTS();
        } else {
            curRecvTS = 0;
        }
        return curRecvTS;
    }

    public synchronized float f() {
        float playSpeed;
        if (this.h != null) {
            playSpeed = this.h.getPlaySpeed();
        } else {
            playSpeed = 0.0f;
        }
        return playSpeed;
    }

    public void b(boolean z) {
        this.p = z;
        if (this.h != null) {
            this.h.enableHWAcceleration(z);
        }
    }

    public void c(boolean z) {
        this.o = z;
        if (this.h != null) {
            this.h.enableRealTimePlay(z);
        }
    }

    public void d(boolean z) {
        this.q = z;
        if (this.h != null) {
            this.h.setMute(z);
        }
    }

    public static void a(Context context, int i) {
        TXCAudioBasePlayController.setAudioMode(context, i);
    }

    public int g() {
        if (d.a().d()) {
            if (this.j != TXEAudioDef.TXE_AEC_TRAE) {
                return this.j;
            }
            TXCLog.e(g, "audio track has start, but aec type is trae!!" + this.j);
            return TXEAudioDef.TXE_AEC_NONE;
        } else if (!TXCTraeJNI.nativeTraeIsPlaying()) {
            return TXEAudioDef.TXE_AEC_NONE;
        } else {
            if (this.j == TXEAudioDef.TXE_AEC_TRAE) {
                return this.j;
            }
            TXCLog.e(g, "trae engine has start, but aec type is not trae!!" + this.j);
            return TXEAudioDef.TXE_AEC_TRAE;
        }
    }

    public TXAudioJitterBufferReportInfo h() {
        if (this.h != null) {
            return this.h.getReportInfo();
        }
        return null;
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.h != null) {
                    this.h.setMute(this.q);
                    return;
                }
                return;
            case 1:
                if (this.h != null) {
                    this.h.setMute(true);
                    return;
                }
                return;
            case 2:
                if (this.h != null) {
                    this.h.setMute(true);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
