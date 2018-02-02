package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.mm.ae.g;
import com.tencent.mm.ae.g$a;
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

public class a implements g$a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static volatile a tYP = null;
    private int fvx;
    public List<a> gxL = new LinkedList();
    public SensorController kCP;
    private boolean kCS = true;
    public ay kCT;
    private long kCU = -1;
    private boolean kCV;
    private boolean kCZ = false;
    private g mql = ((o) com.tencent.mm.kernel.g.h(o.class)).un();
    String path;

    private a() {
        ar.Hg();
        Boolean bool = (Boolean) c.CU().get(26, Boolean.valueOf(false));
        this.kCV = bool.booleanValue();
        this.kCS = !bool.booleanValue();
        if (this.mql != null) {
            this.mql.a(this);
            this.mql.a(this);
            this.mql.aM(this.kCS);
        } else {
            x.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (this.kCP == null) {
            this.kCP = new SensorController(ac.getContext());
        }
        if (this.kCT == null) {
            this.kCT = new ay(ac.getContext());
        }
    }

    public static a bXQ() {
        if (tYP == null) {
            synchronized (a.class) {
                if (tYP == null) {
                    tYP = new a();
                }
            }
        }
        return tYP;
    }

    public final boolean startPlay(String str, int i) {
        if (this.mql == null) {
            x.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.mql.stop();
        if (!(this.kCP == null || this.kCP.xic)) {
            this.kCP.a(this);
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
        for (a aVar : this.gxL) {
            if (aVar != null) {
                aVar.Ra(str);
            }
        }
        return true;
    }

    public final void stopPlay() {
        x.i("MicroMsg.RecordVoiceHelper", "stop play");
        ae.Vd("keep_app_silent");
        if (this.mql != null) {
            this.mql.stop();
            for (a aVar : this.gxL) {
                if (aVar != null) {
                    aVar.bXP();
                }
            }
        }
        if (this.kCP != null) {
            this.kCP.cgf();
        }
        if (this.kCT != null) {
            this.kCT.cgg();
        }
    }

    public final boolean aIA() {
        if (this.mql != null) {
            return this.mql.isPlaying();
        }
        x.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void onError() {
        x.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
    }

    public final void vh() {
        x.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
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
                    this.kCS = false;
                } else if (this.mql == null || this.mql.isPlaying()) {
                    if (this.mql != null) {
                        this.mql.aM(z);
                    }
                    this.kCS = z;
                    if (!z) {
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
