package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.g.a.sk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements a {
    final /* synthetic */ o shh;

    o$1(o oVar) {
        this.shh = oVar;
    }

    public final boolean uF() {
        this.shh.shf += 100;
        this.shh.shg += (this.shh.shd.getMaxAmplitude() * 100) / 100;
        if (this.shh.shf < 3000) {
            return true;
        }
        boolean z;
        o oVar = this.shh;
        x.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
        oVar.shd.vi();
        oVar.she.TG();
        oVar.shg /= 30;
        if (oVar.shg >= 30) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[]{Integer.valueOf(oVar.shg), Boolean.valueOf(z)});
        b skVar = new sk();
        skVar.fKf.fKg = z;
        com.tencent.mm.sdk.b.a.xef.m(skVar);
        return false;
    }
}
