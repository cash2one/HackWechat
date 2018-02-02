package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private static final String TAG = TAG;
    public static final a pwv = new a((byte) 0);
    final b gJQ;
    private e gJT;

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i(eVar, "dispatcher");
        b.c.b.e.i(eVar2, "callback");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        e eVar = this.gJT;
        if (eVar != null) {
            eVar.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 602;
    }
}
