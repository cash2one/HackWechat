package com.tencent.mm.plugin.scanner.a;

import android.os.Bundle;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b pSJ;

    b$1(b bVar) {
        this.pSJ = bVar;
    }

    public final void m(int i, Bundle bundle) {
        x.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[]{Integer.valueOf(i)});
        b kgVar = new kg();
        kgVar.fBC.fBA = i;
        kgVar.fBC.activity = this.pSJ.mActivity;
        kgVar.fBC.fov = this.pSJ.pSD;
        kgVar.fBC.fBD = bundle;
        com.tencent.mm.sdk.b.a.xef.m(kgVar);
    }
}
