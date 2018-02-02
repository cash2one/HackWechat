package com.tencent.mm.plugin.music.model.g;

import android.os.Looper;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements c {
    public boolean fAC;
    protected boolean oKA;
    protected com.tencent.mm.plugin.music.model.g.c.a oKB;
    private aq oKz;
    public String oMe = "";

    protected final void bew() {
        this.oKz = new aq();
        this.oKz.eV(ac.getContext());
        this.oKz.a(new 1(this));
    }

    public final void bex() {
        if (this.oKz != null) {
            this.oKz.end();
            this.oKz.cfS();
        }
    }

    public final void n(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPreparintEvent %b", new Object[]{Boolean.valueOf(Qq())});
        this.oMe = "waiting";
        b jsVar = new js();
        jsVar.fAz.action = 11;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "waiting";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    public final void o(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[]{Boolean.valueOf(Qq())});
        this.oMe = "canplay";
        b jsVar = new js();
        jsVar.fAz.action = 9;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "canplay";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    public final void p(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(Qq())});
        this.oMe = "play";
        b jsVar = new js();
        jsVar.fAz.action = 0;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "play";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.bdw();
        f.hkx = System.currentTimeMillis();
        f.c(h.bdz().bdo());
    }

    public final void q(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.oMe = "play";
        b jsVar = new js();
        jsVar.fAz.action = 1;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "play";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.hkx = System.currentTimeMillis();
    }

    public final void r(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.oMe = "pause";
        b jsVar = new js();
        jsVar.fAz.action = 3;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "pause";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.xS();
    }

    public final void s(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oMe = "stop";
        b jsVar = new js();
        jsVar.fAz.action = 2;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "stop";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.g.a.js.a aVar = jsVar.fAz;
        boolean z = this.fAC;
        this.fAC = false;
        aVar.fAC = z;
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.bdw();
    }

    public final void t(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.oMe = "seeked";
        b jsVar = new js();
        jsVar.fAz.action = 8;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "seeked";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    public final void u(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.oMe = "seeking";
        b jsVar = new js();
        jsVar.fAz.action = 12;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "seeking";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    public final void v(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oMe = "ended";
        b jsVar = new js();
        jsVar.fAz.action = 7;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "ended";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.bdw();
        if (h.bdz().mode == 2) {
            h.bdz().bdr();
        }
    }

    public final void a(asv com_tencent_mm_protocal_c_asv, int i) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[]{Integer.valueOf(i)});
        this.oMe = "error";
        b jsVar = new js();
        jsVar.fAz.action = 4;
        jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
        jsVar.fAz.state = "error";
        jsVar.fAz.duration = (long) getDuration();
        jsVar.fAz.fAB = bdP();
        jsVar.fAz.errCode = h.tI(i);
        jsVar.fAz.fnL = h.tJ(i);
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        f.bdw();
    }

    public final void w(asv com_tencent_mm_protocal_c_asv) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        a(com_tencent_mm_protocal_c_asv, -1);
    }

    public final void a(com.tencent.mm.plugin.music.model.g.c.a aVar) {
        this.oKB = aVar;
    }
}
