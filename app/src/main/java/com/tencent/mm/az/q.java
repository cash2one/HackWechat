package com.tencent.mm.az;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends c<lu> {
    private static long gyK = 86400000;

    public q() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return QF();
    }

    private static boolean QF() {
        x.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + wN());
        if (wN()) {
            c.QB().update();
        }
        return false;
    }

    private static boolean wN() {
        if (bh.by(Long.valueOf(bh.c((Long) g.Dj().CU().get(81938, null))).longValue()) * 1000 > gyK) {
            return true;
        }
        return false;
    }
}
