package com.tencent.mm.ag;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements b {
    final /* synthetic */ k hpT;

    k$1(k kVar) {
        this.hpT = kVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (this.hpT.userName.equals((String) obj) && this.hpT.hpN == 1) {
            x.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[]{this.hpT.userName});
            this.hpT.ke(this.hpT.userName);
            ((h) g.h(h.class)).EY().b(this.hpT.hpS);
        }
    }
}
