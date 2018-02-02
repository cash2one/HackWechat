package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class z implements e {
    public z() {
        ar.CG().a(1223, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public static void b(String str, int i, int i2, String str2, String str3) {
        x.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str3});
        ar.CG().a(new bg(str, i, i2, str2, str3), 0);
    }
}
