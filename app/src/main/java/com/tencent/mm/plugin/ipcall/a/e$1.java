package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends c<bc> {
    final /* synthetic */ e nCy;

    e$1(e eVar) {
        this.nCy = eVar;
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 39) {
            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
            byte[] e = e.e(bcVar.fpl.filePath, 0, -1);
            if (e != null) {
                this.nCy.az(e);
            } else {
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
