package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class am$a$2 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ a vfl;

    am$a$2(a aVar, k kVar, int i, int i2) {
        this.vfl = aVar;
        this.flZ = kVar;
        this.fma = i;
        this.fmb = i2;
    }

    public final void run() {
        int i;
        long j;
        long j2 = 0;
        Object obj = null;
        a.vC();
        if (this.flZ.getType() == 222) {
            x.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + this.fma + " errCode:" + this.fmb);
            i = 0;
            j = -1;
        } else if (this.flZ.getType() == 221) {
            a.a(this.vfl);
            j = ((ab) this.flZ).veI;
            i = ((ab) this.flZ).retCode;
        } else if (this.flZ.getType() == 220) {
            long j3;
            a.b(this.vfl);
            long j4 = ((ak) this.flZ).veI;
            int i2 = ((ak) this.flZ).retCode;
            ak akVar = (ak) this.flZ;
            String str = akVar.veF == null ? null : akVar.veF.field_mediaSvrId;
            akVar = (ak) this.flZ;
            if (akVar.veF == null) {
                j3 = 0;
            } else {
                j3 = akVar.veF.field_msgInfoId;
            }
            String str2 = (String) a.c(this.vfl).remove(Long.valueOf(j3));
            if (!bh.ov(((ak) this.flZ).hBn)) {
                obj = 1;
            }
            if (obj == null && !bh.ov(str)) {
                c bVar = new b();
                an.aqd().b(j4, bVar);
                if (bVar.xjy == j4) {
                    l.a(bVar.field_msgInfoId, str, null);
                    x.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                    a.u(bVar.field_msgInfoId, str2);
                }
            }
            i = i2;
            j = j4;
        } else {
            x.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + this.flZ.getType());
            a.vD();
            return;
        }
        if (!(j == -1 || this.vfl.flP.get(Long.valueOf(j)) == null)) {
            j2 = ((g.a) this.vfl.flP.get(Long.valueOf(j))).zi();
            this.vfl.flP.remove(Long.valueOf(j));
        }
        x.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + this.flZ.getType() + " errtype:" + this.fma + " errCode:" + this.fmb + " retCode:" + i + " rowid:" + j + " time:" + j2);
        if (this.fma != 0) {
            a.d(this.vfl);
        }
        x.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.bl() + " stop:" + a.e(this.vfl) + " running:" + a.f(this.vfl) + " recving:" + a.g(this.vfl) + " sending:" + a.h(this.vfl));
        if (a.e(this.vfl) > 0) {
            a.i(this.vfl);
        } else if (!(a.h(this.vfl) || a.g(this.vfl))) {
            a.j(this.vfl);
        }
        a.vD();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
