package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.x;

class v$8 implements f {
    final /* synthetic */ v ppT;
    final /* synthetic */ a ppU;

    v$8(v vVar, a aVar) {
        this.ppT = vVar;
        this.ppU = aVar;
    }

    public final void a(int i, int i2, k kVar) {
        x.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i >= i2) {
            x.i("MicroMsg.ShareModeMailAppService", "finish send");
            if (this.ppU != null) {
                this.ppU.bkq();
            }
        }
    }
}
