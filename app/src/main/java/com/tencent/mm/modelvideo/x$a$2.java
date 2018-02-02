package com.tencent.mm.modelvideo;

import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.sdk.platformtools.x;

class x$a$2 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ a hWt;

    x$a$2(a aVar, k kVar, int i, int i2) {
        this.hWt = aVar;
        this.flZ = kVar;
        this.fma = i;
        this.fmb = i2;
    }

    public final void run() {
        int i;
        String str;
        a.JO();
        String str2;
        if (this.flZ.getType() == 150) {
            a.b(this.hWt);
            str2 = ((d) this.flZ).fileName;
            x.hWk = str2;
            int i2 = ((d) this.flZ).retCode;
            a.c(this.hWt);
            i = i2;
            str = str2;
        } else if (this.flZ.getType() == f.CTRL_INDEX) {
            a.d(this.hWt);
            a.e(this.hWt);
            if (this.flZ instanceof g) {
                str2 = ((g) this.flZ).fileName;
                i = ((g) this.flZ).retCode;
                str = str2;
            } else if (this.flZ instanceof h) {
                i = 0;
                str = ((h) this.flZ).fileName;
            } else {
                i = 0;
                str = null;
            }
        } else {
            x.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + this.flZ.getType());
            a.Ut();
            return;
        }
        long j = 0;
        if (!(str == null || this.hWt.flP.get(str) == null)) {
            j = ((g.a) this.hWt.flP.get(str)).zi();
            this.hWt.flP.remove(str);
        }
        x.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + this.flZ.getType() + " errtype:" + this.fma + " errCode:" + this.fmb + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.fma == 3 && i != 0) {
            a.f(this.hWt);
        } else if (this.fma != 0) {
            a.a(this.hWt, 0);
        }
        x.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.JM() + " stop:" + a.g(this.hWt) + " running:" + a.h(this.hWt) + " recving:" + a.i(this.hWt) + " sending:" + a.j(this.hWt));
        if (a.g(this.hWt) > 0) {
            a.a(this.hWt);
        } else if (!(a.j(this.hWt) || a.i(this.hWt))) {
            a.k(this.hWt);
        }
        a.Ut();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
