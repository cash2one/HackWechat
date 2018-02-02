package com.tencent.mm.plugin.ext;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class b$10 implements b {
    final /* synthetic */ b lZF;

    b$10(b bVar) {
        this.lZF = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (ar.Hj()) {
            ar.Hg();
            if (mVar == c.EY()) {
                b.d(this.lZF);
            }
        } else {
            x.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
        }
    }
}
