package com.tencent.mm.plugin.offline;

import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.x;

class k$3 implements a {
    final /* synthetic */ k oWh;

    k$3(k kVar) {
        this.oWh = kVar;
    }

    public final void a(f fVar, g gVar, boolean z) {
        x.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            k.bha().dc(7, 7);
        }
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
    }
}
