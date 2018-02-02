package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;

class f$3 extends c<jy> {
    final /* synthetic */ f oOg;

    f$3(f fVar) {
        this.oOg = fVar;
    }

    public final /* synthetic */ b a(int i, k kVar, b bVar) {
        jy jyVar = (jy) bVar;
        c cVar = (c) kVar;
        jyVar.fBb.fBh = cVar.beT();
        jyVar.fBb.fBj = cVar.beU();
        jyVar.fBb.fBi = cVar.beV();
        jyVar.fBb.fut = jyVar.fBa.fut;
        return jyVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jy jyVar = (jy) bVar;
        if (jyVar.fBa.fAJ) {
            c.k(jyVar);
        } else {
            l(jyVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        jy jyVar = (jy) bVar;
        return new c(jyVar.fBa.fut, jyVar.fBa.fBc, jyVar.fBa.fzt, jyVar.fBa.fBd, jyVar.fBa.fBe, jyVar.fBa.fBf, jyVar.fBa.fBg);
    }

    public final int axw() {
        return JsApiScanCode.CTRL_INDEX;
    }
}
