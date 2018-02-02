package com.tencent.mm.s;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class c implements ap {
    private static c gLN;
    private a gLO;

    private c() {
        if (a.gLt == null) {
            a.gLt = new a();
        }
        this.gLO = a.gLt;
    }

    public final void onAccountRelease() {
        a aVar = this.gLO;
        aVar.gLv.clear();
        b bVar = aVar.gLu;
        x.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.gLD.clear();
        bVar.gLF.clear();
        bVar.gLE.clear();
        bVar.gLG.clear();
        aVar.initialized = false;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.gLO.init();
    }

    public final void br(boolean z) {
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public static a Bq() {
        g.Dh().Ct();
        if (gLN == null) {
            c cVar = new c();
            gLN = cVar;
            cVar.gLO.init();
        }
        return gLN.gLO;
    }
}
