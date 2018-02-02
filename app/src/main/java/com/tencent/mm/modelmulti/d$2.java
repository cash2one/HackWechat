package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements e {
    final /* synthetic */ d hFe;

    d$2(d dVar) {
        this.hFe = dVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        kVar.hmF = true;
    }
}
