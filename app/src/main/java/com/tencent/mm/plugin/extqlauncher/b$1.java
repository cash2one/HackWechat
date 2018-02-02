package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class b$1 implements b {
    final /* synthetic */ b mck;

    b$1(b bVar) {
        this.mck = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (!this.mck.mcb) {
            ar.Hg();
            if (mVar != c.Fd()) {
                return;
            }
            if (mVar == null || obj == null) {
                x.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
            } else if (ac.getContext() == null || !ar.Hj()) {
                x.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
            } else {
                this.mck.aGd();
            }
        }
    }
}
