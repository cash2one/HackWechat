package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.by.h.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.x$a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public class e implements ap {
    private m oqS = new m();
    private c oqT = new 1(this);
    private c oqU = new 2(this);

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x$a TZ = o.TZ();
        m mVar = this.oqS;
        x.k("MicroMsg.VideoService", "addVideoMsgSendCallback %s", mVar);
        if (!(mVar == null || TZ.hWo == null || TZ.hWo.contains(mVar))) {
            TZ.hWo.add(mVar);
        }
        a.xef.a(this.oqU);
        a.xef.b(this.oqT);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x$a TZ = o.TZ();
        m mVar = this.oqS;
        if (!(mVar == null || TZ.hWo == null)) {
            TZ.hWo.remove(mVar);
        }
        a.xef.c(this.oqU);
        j.ouM.Es();
        a.xef.c(this.oqT);
    }
}
