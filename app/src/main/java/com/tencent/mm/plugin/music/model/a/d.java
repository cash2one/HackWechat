package com.tencent.mm.plugin.music.model.a;

import android.os.Looper;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.model.a.b.a;
import com.tencent.mm.plugin.music.model.g.c;
import com.tencent.mm.plugin.music.model.g.c$a;
import com.tencent.mm.plugin.music.model.g.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d implements c {
    protected boolean oKA;
    protected c$a oKB;
    protected a oKv = null;
    aq oKz;

    public abstract String bdR();

    public abstract String getAppId();

    public final void bdN() {
    }

    public final boolean bdO() {
        return false;
    }

    public boolean bdP() {
        return false;
    }

    public final com.tencent.mm.av.d bdQ() {
        return null;
    }

    public final void bdS() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent %b", new Object[]{Boolean.valueOf(Qq())});
        b tVar = new t();
        tVar.fnK.action = 7;
        tVar.fnK.state = "canplay";
        tVar.fnK.duration = (long) getDuration();
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
    }

    public final void bdT() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(Qq())});
        b tVar = new t();
        tVar.fnK.action = 0;
        tVar.fnK.state = "play";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.onStart(bdR());
        }
    }

    public final void bdU() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        b tVar = new t();
        tVar.fnK.action = 1;
        tVar.fnK.state = "play";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.onStart(bdR());
        }
    }

    public final void bdV() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        b tVar = new t();
        tVar.fnK.action = 2;
        tVar.fnK.state = "pause";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.Ge(bdR());
        }
    }

    public final void bdW() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b tVar = new t();
        tVar.fnK.action = 3;
        tVar.fnK.state = "stop";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.zN(bdR());
        }
    }

    public final void bdX() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        b tVar = new t();
        tVar.fnK.action = 6;
        tVar.fnK.state = "seeked";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
    }

    public final void bdY() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b tVar = new t();
        tVar.fnK.action = 5;
        tVar.fnK.state = "ended";
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.Gf(bdR());
        }
    }

    public final void ts(int i) {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[]{Integer.valueOf(i)});
        b tVar = new t();
        tVar.fnK.action = 4;
        tVar.fnK.state = "error";
        tVar.fnK.errCode = h.tI(i);
        tVar.fnK.fnL = h.tJ(i);
        tVar.fnK.fnF = bdR();
        tVar.fnK.appId = getAppId();
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
        if (this.oKv != null) {
            this.oKv.onError(bdR());
        }
    }

    public final void bdZ() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        ts(-1);
    }

    public final void a(c$a com_tencent_mm_plugin_music_model_g_c_a) {
        this.oKB = com_tencent_mm_plugin_music_model_g_c_a;
    }

    public final void a(a aVar) {
        this.oKv = aVar;
    }
}
