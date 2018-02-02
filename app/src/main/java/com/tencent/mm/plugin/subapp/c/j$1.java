package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class j$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ j rWH;

    j$1(j jVar, k kVar, int i, int i2) {
        this.rWH = jVar;
        this.flZ = kVar;
        this.fma = i;
        this.fmb = i2;
    }

    public final void run() {
        int i;
        String str;
        j.vC();
        String str2;
        if (this.flZ.getType() == FileUtils.S_IWUSR) {
            j.a(this.rWH);
            str2 = ((e) this.flZ).fileName;
            i = ((e) this.flZ).retCode;
            str = str2;
        } else if (this.flZ.getType() == 329) {
            j.b(this.rWH);
            str2 = ((b) this.flZ).fileName;
            i = ((b) this.flZ).retCode;
            str = str2;
        } else {
            x.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + this.flZ.getType());
            j.vD();
            return;
        }
        long j = 0;
        if (!(str == null || this.rWH.flP.get(str) == null)) {
            j = ((a) this.rWH.flP.get(str)).zi();
            this.rWH.flP.remove(str);
        }
        x.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + this.flZ.getType() + " errtype:" + this.fma + " errCode:" + this.fmb + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.fma == 3 && i != 0) {
            j.c(this.rWH);
        } else if (this.fma != 0) {
            j.a(this.rWH, 0);
        }
        x.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.bl() + " stop:" + j.d(this.rWH) + " running:" + j.e(this.rWH) + " recving:" + j.f(this.rWH) + " sending:" + j.g(this.rWH));
        if (j.d(this.rWH) > 0) {
            j.h(this.rWH);
        } else if (!(j.g(this.rWH) || j.f(this.rWH))) {
            j.i(this.rWH);
        }
        j.vD();
    }
}
