package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class c implements e {
    public static final int a = a.e;
    public static final int b = a.f;
    public static final int c = a.h;
    public static final int d = TXEAudioDef.TXE_REVERB_TYPE_0;
    public static final int e = TXEAudioDef.TXE_AEC_NONE;
    public static final int f = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    static c g = new c();
    private static final String h = ("AudioCenter:" + c.class.getSimpleName());
    private WeakReference<e> i;
    private int j = a;
    private int k = b;
    private int l = a.h;
    private int m = d;
    private boolean n = false;
    private int o = e;
    private boolean p = false;
    private boolean q = false;
    private Context r;
    private float s = 1.0f;
    private com.tencent.liteav.audio.impl.Record.c t = null;

    private c() {
    }

    public static c a() {
        return g;
    }

    public int a(Context context) {
        if (context == null) {
            TXCLog.e(h, "invalid param, start record failed!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        this.r = context.getApplicationContext();
        com.tencent.liteav.audio.impl.c.a().a(this.r);
        com.tencent.liteav.audio.impl.c.a().a(this);
        if (com.tencent.liteav.audio.impl.a.b(this.o) != TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK) {
            TXCLog.w(h, "start recorder failed, with aec type " + this.o + ", invalid aec player has started!");
        }
        if (this.t == null || !this.t.isRecording()) {
            if (this.t == null) {
                if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                    this.t = new g();
                } else {
                    this.t = new TXCAudioSysRecordController();
                }
            }
            if (this.t != null) {
                g();
                return this.t.startRecord(this.r);
            }
            TXCLog.e(h, "start Record failed! controller is null!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        TXCLog.e(h, "record has started, can not start again!");
        return TXEAudioDef.TXE_AUDIO_RECORD_ERR_REPEAT_OPTION;
    }

    public int b() {
        int i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK;
        if (this.t != null) {
            i = this.t.stopRecord();
            this.t = null;
        }
        this.i = null;
        this.j = a;
        this.k = b;
        this.l = a.h;
        this.m = d;
        this.n = false;
        this.o = e;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = 1.0f;
        g();
        com.tencent.liteav.audio.impl.c.a().b(this);
        return i;
    }

    public boolean c() {
        if (this.t != null) {
            return this.t.isRecording();
        }
        return false;
    }

    public void a(boolean z) {
        this.q = z;
        if (this.t != null) {
            this.t.setIsCustomRecord(z);
        }
    }

    public void a(e eVar) {
        this.i = new WeakReference(eVar);
        if (this.t != null) {
            this.t.setListener(eVar);
        }
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.j;
    }

    public void b(int i) {
        TXCLog.i(h, "setSampleRate: " + i);
        this.j = i;
        if (this.t != null) {
            this.t.setSamplerate(i);
        }
    }

    public void c(int i) {
        TXCLog.i(h, "setChannels: " + i);
        this.k = i;
        if (this.t != null) {
            this.t.setChannels(i);
        }
    }

    public void d(int i) {
        TXCLog.i(h, "setReverbType: " + i);
        this.m = i;
        if (this.t != null) {
            this.t.setReverbType(i);
        }
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
        } else if (b.a().f()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
        } else {
            a.a(b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
        }
    }

    private void a(int i, Context context) {
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            if (this.o != i) {
                if (this.t != null && this.t.isRecording()) {
                    this.t.stopRecord();
                    this.t = null;
                    this.o = i;
                    a(this.r);
                }
                this.o = i;
            }
            if (this.t != null) {
                this.t.setAECType(i);
                return;
            }
            return;
        }
        TXCLog.e(h, "set aec type failed, check trae library failed!!");
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        TXCLog.i(h, "setMute: " + z);
        this.n = z;
        if (this.t != null) {
            this.t.setMute(z);
        }
    }

    public void a(float f) {
        TXCLog.i(h, "setVolume: " + f);
        this.s = f;
        if (this.t != null) {
            this.t.setVolume(f);
        }
    }

    public void a(byte[] bArr) {
        if (this.t != null) {
            this.t.sendCustomPCMData(bArr);
        }
    }

    public int f() {
        if (f.a().c()) {
            if (this.o != TXEAudioDef.TXE_AEC_TRAE) {
                return this.o;
            }
            TXCLog.e(h, "audio mic has start, but aec type is trae!!" + this.o);
            return TXEAudioDef.TXE_AEC_NONE;
        } else if (!TXCTraeJNI.nativeTraeIsRecording()) {
            return TXEAudioDef.TXE_AEC_NONE;
        } else {
            if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                return this.o;
            }
            TXCLog.e(h, "trae engine has start, but aec type is not trae!!" + this.o);
            return TXEAudioDef.TXE_AEC_TRAE;
        }
    }

    private void g() {
        if (this.i != null) {
            a((e) this.i.get());
        }
        a(this.q);
        b(this.j);
        c(this.k);
        d(this.m);
        a(this.o, this.r);
        b(this.p);
        c(this.n);
        a(this.s);
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.t != null) {
                    this.t.setMute(this.n);
                    return;
                }
                return;
            case 1:
                if (this.t != null) {
                    this.t.setMute(true);
                    return;
                }
                return;
            case 2:
                if (this.t != null) {
                    this.t.setMute(true);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
