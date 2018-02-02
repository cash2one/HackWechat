package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.na;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<na> {
    public j() {
        this.xen = na.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        na naVar = (na) bVar;
        if (!g.Dh().Cy()) {
            x.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (naVar instanceof na) {
            x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.aJS();
            if (a.aJT() != null) {
                a.aJS();
                a.aJT();
                c.aKa();
                x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            return true;
        }
        return false;
    }
}
