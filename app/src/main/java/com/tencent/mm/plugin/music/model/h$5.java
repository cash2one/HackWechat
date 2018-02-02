package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.e;
import com.tencent.mm.plugin.music.model.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;

class h$5 extends c<e> {
    final /* synthetic */ h oKd;

    h$5(h hVar) {
        this.oKd = hVar;
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((e) bVar).fmQ.fmR) {
            a aVar = new a();
            ar.Hg();
            long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xuu, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue < a.oKV.longValue()) {
                x.e("MicroMsg.CleanMusicController", "don't scanMusic because the time is in one day");
            } else {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xuu, Long.valueOf(currentTimeMillis));
                com.tencent.mm.sdk.f.e.b(new a$2(aVar), "ScanMusicThread", 1);
            }
        }
        return false;
    }
}
