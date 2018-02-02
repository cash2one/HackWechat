package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<qg> {
    public m() {
        this.xen = qg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((qg) bVar) instanceof qg) {
            x.d("MicroMsg.SnsSyncListener", "NetSceneSnsSync");
            g.Dk();
            g.Di().gPJ.a(new t(), 0);
            return true;
        }
        x.f("MicroMsg.SnsSyncListener", "mismatched event");
        return false;
    }
}
