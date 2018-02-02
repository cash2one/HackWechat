package com.tencent.mm.plugin.j;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.p;

public final class a extends p implements com.tencent.mm.plugin.auth.a.a {
    private static a kYL;

    private a() {
        super(g.class);
    }

    public static synchronized a axt() {
        a aVar;
        synchronized (a.class) {
            if (kYL == null) {
                kYL = new a();
            }
            aVar = kYL;
        }
        return aVar;
    }

    public final void a(f fVar, i.g gVar, boolean z) {
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        if (bVar.vBT.lOd != 0) {
            ag.y(new 1(bVar.vBT.vSD, bVar.vBT.vSE, bVar.vBT.vSF));
        }
    }
}
