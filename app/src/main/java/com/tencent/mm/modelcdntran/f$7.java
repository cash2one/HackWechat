package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class f$7 implements Runnable {
    final /* synthetic */ f hta;
    final /* synthetic */ int htd;
    final /* synthetic */ int hte;
    final /* synthetic */ String uS;

    f$7(f fVar, String str, int i, int i2) {
        this.hta = fVar;
        this.uS = str;
        this.htd = i;
        this.hte = i2;
    }

    public final void run() {
        j jVar = (j) this.hta.hsu.get(this.uS);
        if (jVar != null) {
            b kzVar = new kz();
            kzVar.fCj.fuL = 3;
            kzVar.fCj.retCode = 0;
            kzVar.fCj.mediaId = this.uS;
            kzVar.fCj.offset = this.htd;
            kzVar.fCj.length = this.hte;
            a.xef.m(kzVar);
            if (this.htd == 0 && this.hte >= jVar.htI) {
                f.a(t.nF(jVar.filename), jVar.htI, jVar.htH);
            }
        }
    }
}
