package com.tencent.mm.ui;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class x$2 implements b {
    final /* synthetic */ x xKV;

    x$2(x xVar) {
        this.xKV = xVar;
    }

    public final void a(int i, m mVar, Object obj) {
        int aV = t.aV(obj);
        x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(aV), mVar});
        ar.Hg();
        if (mVar != c.CU() || aV <= 0) {
            x.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(aV), mVar});
            return;
        }
        this.xKV.cnm();
        if (aV == 143618) {
            x.a(this.xKV);
        } else if (aV == 204817 || aV == 204820) {
            x.b(this.xKV);
        }
    }
}
