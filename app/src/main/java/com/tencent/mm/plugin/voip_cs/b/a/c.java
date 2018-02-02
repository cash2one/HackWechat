package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class c {
    private a nEA = new 1(this);
    public com.tencent.mm.e.b.c oFS = new com.tencent.mm.e.b.c(v2protocal.oFK, 1, 1);
    private com.tencent.mm.plugin.voip.model.a oFV = new 2(this);
    public b sky;

    public c() {
        this.oFS.et(20);
        this.oFS.aP(true);
        this.oFS.vq();
        this.oFS.n(1, false);
        this.oFS.aO(true);
        this.oFS.fkK = this.nEA;
        this.sky = new b();
        this.sky.Y(v2protocal.oFK, 20, 0);
        this.sky.l(ac.getContext(), false);
        this.sky.siT = this.oFV;
    }

    private boolean jd(boolean z) {
        if (this.sky != null) {
            return this.sky.jd(z);
        }
        return false;
    }

    public final void jf(boolean z) {
        x.j("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + z, new Object[0]);
        x.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + ar.Hh().xP());
        if (ar.Hh().xL()) {
            z = false;
        }
        if (q.gFV.gCG) {
            q.gFV.dump();
            if (q.gFV.gCH > 0) {
                jd(z);
            }
        }
        if (q.gFV.gDj >= 0 || q.gFV.gDk >= 0) {
            jd(z);
        }
        if (this.sky != null) {
            ar.Hh().b(z, this.sky.bGh());
            com.tencent.mm.plugin.voip_cs.b.b.a bIS = com.tencent.mm.plugin.voip_cs.b.b.bIS();
            int td = z ? bIS.nEG.td(401) : bIS.nEG.td(e.CTRL_INDEX);
            if (td < 0) {
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + td);
            }
        }
    }
}
