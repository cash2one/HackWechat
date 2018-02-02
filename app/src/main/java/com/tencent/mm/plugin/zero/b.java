package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.br;
import com.tencent.mm.z.br.a;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private r vaA;
    private br vaz;

    public final r Qc() {
        g.Dk();
        g.Dh().Ct();
        if (this.vaA == null) {
            this.vaA = new r();
        }
        return this.vaA;
    }

    public final br bXT() {
        g.Dk();
        g.Dh().Ct();
        if (this.vaz == null) {
            this.vaz = new br(new a(this) {
                final /* synthetic */ b vaB;

                {
                    this.vaB = r1;
                }

                public final boolean Id() {
                    return this.vaB.Qc().hHl == null;
                }
            });
        }
        return this.vaz;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.vaA != null) {
            r rVar = this.vaA;
            x.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[]{Integer.valueOf(rVar.hHi.size()), Integer.valueOf(rVar.hHj.size()), rVar.hHl});
            rVar.hHi.clear();
            rVar.hHj.clear();
        }
        if (this.vaz != null) {
            this.vaz.HY();
        }
    }
}
