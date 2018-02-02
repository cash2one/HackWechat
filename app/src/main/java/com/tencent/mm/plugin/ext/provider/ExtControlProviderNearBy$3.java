package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.jy;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class ExtControlProviderNearBy$3 extends b {
    final /* synthetic */ ExtControlProviderNearBy maO;

    ExtControlProviderNearBy$3(ExtControlProviderNearBy extControlProviderNearBy) {
        this.maO = extControlProviderNearBy;
        super(0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if ((bVar instanceof jy) && ExtControlProviderNearBy.c(this.maO) != null) {
            jy jyVar = (jy) bVar;
            x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
            if (i == 0 && i2 == 0) {
                ExtControlProviderNearBy.a(this.maO, jyVar.fBb.fBi);
                if (ExtControlProviderNearBy.d(this.maO) == null || ExtControlProviderNearBy.d(this.maO).size() == 0) {
                    x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                    ExtControlProviderNearBy.c(this.maO).countDown();
                } else {
                    if (ExtControlProviderNearBy.d(this.maO).size() > 10) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(this.maO).size());
                        ExtControlProviderNearBy.d(this.maO).subList(10, ExtControlProviderNearBy.d(this.maO).size()).clear();
                    }
                    ExtControlProviderNearBy.a(this.maO, new CountDownLatch(ExtControlProviderNearBy.d(this.maO).size()));
                    ExtControlProviderNearBy.c(this.maO).countDown();
                    ExtControlProviderNearBy.e(this.maO);
                }
            } else {
                x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                ExtControlProviderNearBy.c(this.maO).countDown();
            }
            ExtControlProviderNearBy.f(this.maO);
        }
    }
}
