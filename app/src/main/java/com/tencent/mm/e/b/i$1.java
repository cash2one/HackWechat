package com.tencent.mm.e.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class i$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ i fmc;

    i$1(i iVar, k kVar, int i, int i2) {
        this.fmc = iVar;
        this.flZ = kVar;
        this.fma = i;
        this.fmb = i2;
    }

    public final void run() {
        int i;
        String str;
        i.vC();
        String str2;
        if (this.flZ.getType() == FileUtils.S_IWUSR) {
            i.a(this.fmc);
            str2 = ((e) this.flZ).fileName;
            i = ((e) this.flZ).retCode;
            str = str2;
        } else if (this.flZ.getType() == 127) {
            i.b(this.fmc);
            str2 = ((f) this.flZ).fileName;
            i = ((f) this.flZ).retCode;
            str = str2;
        } else {
            x.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + this.flZ.getType());
            i.vD();
            return;
        }
        long j = 0;
        if (!(str == null || this.fmc.flP.get(str) == null)) {
            j = ((a) this.fmc.flP.get(str)).zi();
            this.fmc.flP.remove(str);
        }
        x.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + this.flZ.getType() + " errtype:" + this.fma + " errCode:" + this.fmb + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.fma == 3 && i != 0) {
            i.c(this.fmc);
        } else if (this.fma != 0) {
            i.a(this.fmc, 0);
        }
        x.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.bl() + " stop:" + i.d(this.fmc) + " running:" + i.e(this.fmc) + " recving:" + i.f(this.fmc) + " sending:" + i.g(this.fmc));
        if (i.d(this.fmc) > 0) {
            i.h(this.fmc);
        } else if (!(i.g(this.fmc) || i.f(this.fmc))) {
            i.i(this.fmc);
            x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[]{Integer.valueOf(this.fma), Integer.valueOf(i), Boolean.valueOf(i.flW)});
            if (i.flW && this.fma == 4) {
                g.Dm().g(new Runnable(this) {
                    final /* synthetic */ i$1 fmd;

                    {
                        this.fmd = r1;
                    }

                    public final void run() {
                        x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                        this.fmd.fmc.run();
                    }
                }, 10000);
            }
        }
        i.vD();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
