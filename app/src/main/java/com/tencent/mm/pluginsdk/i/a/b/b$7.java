package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.b.b.8;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$7 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ int vgF;
    final /* synthetic */ int vgr;
    final /* synthetic */ int vgs;
    final /* synthetic */ b vgv;

    b$7(b bVar, int i, int i2, String str, int i3) {
        this.vgv = bVar;
        this.vgr = i;
        this.vgs = i2;
        this.icE = str;
        this.vgF = i3;
    }

    public final void run() {
        b bVar = this.vgv;
        int i = this.vgr;
        int i2 = this.vgs;
        String str = this.icE;
        int i3 = this.vgF;
        q RW = a.bZC().RW(i.ey(i, i2));
        if (RW != null) {
            boolean z = RW.field_fileUpdated;
            RW.field_fileUpdated = false;
            a.bZC().e(RW);
            if (i3 != bh.getInt(RW.field_fileVersion, 0)) {
                return;
            }
            if (a.bZC().handler == null) {
                x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            } else {
                a.bZC().handler.post(new 8(bVar, i, i2, str, i3, z));
            }
        }
    }
}
