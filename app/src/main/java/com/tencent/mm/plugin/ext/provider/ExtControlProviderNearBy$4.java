package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.jy;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderNearBy$4 implements a {
    final /* synthetic */ ExtControlProviderNearBy maO;

    ExtControlProviderNearBy$4(ExtControlProviderNearBy extControlProviderNearBy) {
        this.maO = extControlProviderNearBy;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!ExtControlProviderNearBy.g(this.maO)) {
            ExtControlProviderNearBy.h(this.maO);
            if (z) {
                b jyVar = new jy();
                jyVar.fBa.fut = ExtControlProviderNearBy.i(this.maO);
                jyVar.fBa.fBc = f;
                jyVar.fBa.fzt = f2;
                jyVar.fBa.fBd = (int) d2;
                jyVar.fBa.fBe = i;
                jyVar.fBa.fBf = "";
                jyVar.fBa.fBg = "";
                if (com.tencent.mm.sdk.b.a.xef.m(jyVar)) {
                    x.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                }
            } else {
                x.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                ExtControlProviderNearBy.f(this.maO);
                ExtControlProviderNearBy.c(this.maO).countDown();
            }
        }
        return false;
    }
}
