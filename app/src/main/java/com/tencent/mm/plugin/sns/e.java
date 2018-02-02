package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.hs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends c<hs> {
    public e() {
        this.xen = hs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hs hsVar = (hs) bVar;
        if (hsVar instanceof hs) {
            if (hsVar.fya.fuL == 0) {
                g.Dk();
                g.Di().gPJ.a(new u(1), 0);
            } else {
                g.Dk();
                g.Di().gPJ.a(new u(hsVar.fya.fuL), 0);
            }
            return true;
        }
        x.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        return false;
    }
}
