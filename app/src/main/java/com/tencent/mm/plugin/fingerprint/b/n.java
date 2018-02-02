package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.a.ra.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<ra> {
    public n() {
        this.xen = ra.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ra raVar = (ra) bVar;
        if (!g.Dh().Cy()) {
            x.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (raVar instanceof ra) {
            x.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean aJZ = c.aJZ();
            x.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is " + aJZ);
            a aVar = new a();
            aVar.fIP = aJZ;
            raVar.fIO = aVar;
            if (raVar.fqI != null) {
                raVar.fqI.run();
            }
            return true;
        }
        return false;
    }
}
