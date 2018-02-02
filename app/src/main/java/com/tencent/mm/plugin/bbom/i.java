package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.booter.notification.e;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.k.f;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements b {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        String string;
        if (bh.ov(str2)) {
            string = ac.getContext().getString(f.eV(str) ? R.l.dSN : R.l.epB);
        } else {
            string = str2;
        }
        e eVar = a.xh().gAh;
        if (!f.zq()) {
            e.cancel();
        }
        try {
            eVar.gzZ.a(j, str, string, str3, str4, false, i);
        } catch (Throwable e) {
            x.e("MicroMsg.Notification.Handle", "push:notify, error");
            x.printErrStackTrace("MicroMsg.Notification.Handle", e, "", new Object[0]);
        }
    }

    public final void arc() {
        a.xh().n(-1, null);
    }
}
