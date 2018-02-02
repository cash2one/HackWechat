package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.fd;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al$a;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<fd> {
    public c() {
        this.xen = fd.class.getName().hashCode();
    }

    private boolean a(fd fdVar) {
        if (fdVar instanceof fd) {
            al$a bvl = ae.bvl();
            bvl.a(fdVar.fud.type, fdVar.fud.username, new 1(this, fdVar));
            bvl.a(1, fdVar.fud.username, fdVar.fud.fuf, fdVar.fud.fug);
            return true;
        }
        x.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        return false;
    }
}
