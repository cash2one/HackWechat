package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class f$6 implements Runnable {
    final /* synthetic */ f hta;
    final /* synthetic */ int htd;
    final /* synthetic */ int hte;
    final /* synthetic */ String uS;

    f$6(f fVar, String str, int i, int i2) {
        this.hta = fVar;
        this.uS = str;
        this.htd = i;
        this.hte = i2;
    }

    public final void run() {
        j jVar = (j) this.hta.hsu.get(this.uS);
        if (jVar != null) {
            if (jVar.htQ != null) {
                jVar.htQ.onDataAvailable(this.uS, this.htd, this.hte);
            }
            b kzVar = new kz();
            kzVar.fCj.fuL = 2;
            kzVar.fCj.retCode = 0;
            kzVar.fCj.mediaId = this.uS;
            kzVar.fCj.offset = this.htd;
            kzVar.fCj.length = this.hte;
            a.xef.m(kzVar);
        }
    }
}
