package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.g;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public final class i implements a, b, SensorController.a {
    public static SensorController kCP;
    private int fvx;
    private List<a> gxL = new LinkedList();
    private boolean kCS = true;
    public ay kCT;
    long kCU = -1;
    private boolean kCV;
    private boolean kCZ = false;
    private g mql = ((o) com.tencent.mm.kernel.g.h(o.class)).un();
    public boolean mqm;
    private int mqn;
    public String path;

    public i() {
        ar.Hg();
        Boolean bool = (Boolean) c.CU().get(26, Boolean.valueOf(false));
        this.kCV = bool.booleanValue();
        this.kCS = !bool.booleanValue();
        if (this.mql != null) {
            this.mql.a((a) this);
            this.mql.a((b) this);
            this.mql.aM(this.kCS);
        } else {
            x.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (kCP == null) {
            kCP = new SensorController(ac.getContext());
        }
        if (this.kCT == null) {
            this.kCT = new ay(ac.getContext());
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.gxL) {
            if (aVar == aVar2) {
                return;
            }
        }
        this.gxL.add(aVar);
    }

    public final void destroy() {
        pause();
        arT();
        kCP = null;
        this.gxL.clear();
    }

    public final void pause() {
        if (this.mql == null) {
            x.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            return;
        }
        if (this.mql.isPlaying()) {
            aIC();
        }
        for (a onPause : this.gxL) {
            onPause.onPause();
        }
    }

    public final boolean startPlay(String str, int i) {
        if (this.mql == null) {
            x.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.mql.stop();
        for (a bj : this.gxL) {
            bj.bj(str, 0);
        }
        if (!(kCP == null || kCP.xic)) {
            kCP.a(this);
            if (this.kCT.O(new 1(this))) {
                this.kCU = 0;
            } else {
                this.kCU = -1;
            }
        }
        this.path = str;
        this.fvx = i;
        if (bh.ov(str) || !this.mql.a(str, this.kCS, true, i)) {
            return false;
        }
        ae.Vc("keep_app_silent");
        return true;
    }

    public final boolean G(String str, int i, int i2) {
        if (this.mql == null) {
            x.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.mql.stop();
        for (a bj : this.gxL) {
            bj.bj(str, i2);
        }
        if (!(kCP == null || kCP.xic)) {
            kCP.a(this);
            if (this.kCT.O(new 2(this))) {
                this.kCU = 0;
            } else {
                this.kCU = -1;
            }
        }
        this.path = str;
        this.fvx = i;
        if (bh.ov(str) || !this.mql.a(str, this.kCS, i, i2)) {
            return false;
        }
        ae.Vc("keep_app_silent");
        ar.Hh().h(this.kCS, false);
        return true;
    }

    public final boolean aIA() {
        if (this.mql != null) {
            return this.mql.isPlaying();
        }
        x.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
        return false;
    }

    public final boolean vg() {
        if (this.mql != null) {
            return this.mql.vg();
        }
        x.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
        return false;
    }

    public final double vf() {
        if (this.mql != null) {
            return this.mql.vf();
        }
        x.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
        return 0.0d;
    }

    public final boolean aIB() {
        x.i("MicroMsg.FavVoiceLogic", "resume play");
        ae.Vc("keep_app_silent");
        if (this.mql != null) {
            return this.mql.vc();
        }
        x.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
        return false;
    }

    public final boolean aIC() {
        x.i("MicroMsg.FavVoiceLogic", "pause play");
        ae.Vd("keep_app_silent");
        if (this.mql != null) {
            return this.mql.pause();
        }
        x.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
        return false;
    }

    public final void stopPlay() {
        x.d("MicroMsg.FavVoiceLogic", "stop play");
        ae.Vd("keep_app_silent");
        if (this.mql != null) {
            this.mql.stop();
        }
        arT();
    }

    public final void onError() {
        x.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.gxL) {
            onFinish.onFinish();
        }
    }

    public final void vh() {
        x.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.gxL) {
            onFinish.onFinish();
        }
    }

    private void arT() {
        if (kCP != null) {
            kCP.cgf();
        }
        if (this.kCT != null) {
            this.kCT.cgg();
        }
    }

    public final void dT(boolean z) {
        boolean z2 = true;
        if (!bh.ov(this.path)) {
            if (this.kCZ) {
                if (z) {
                    z2 = false;
                }
                this.kCZ = z2;
            } else if (z || this.kCU == -1 || bh.bA(this.kCU) <= 400) {
                this.kCZ = false;
                if (this.mql != null && this.mql.vd()) {
                    return;
                }
                if (this.kCV) {
                    if (this.mql != null) {
                        this.mql.aM(false);
                    }
                    ar.Hh().h(false, false);
                    this.kCS = false;
                } else if (this.mql == null || this.mql.isPlaying() || this.mqm) {
                    if (this.mql != null) {
                        this.mql.aM(z);
                    }
                    this.kCS = z;
                    if (this.mqm && !z) {
                        G(this.path, this.fvx, this.mqn);
                    } else if (!z) {
                        startPlay(this.path, this.fvx);
                    }
                } else {
                    this.mql.aM(true);
                    this.kCS = true;
                }
            } else {
                this.kCZ = true;
            }
        }
    }
}
