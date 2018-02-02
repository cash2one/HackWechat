package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements b {
    final /* synthetic */ b thU;

    b$3(b bVar) {
        this.thU = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (str != null && str.equals("gh_43f2581f6fd6")) {
            if (!b.bOu() && this.thU.thR) {
                this.thU.thR = false;
            } else if (b.bOu() && !this.thU.thR) {
                this.thU.connect();
            }
        }
    }
}
