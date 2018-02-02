package com.tencent.mm.plugin.hp;

import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.plugin.hp.b.c;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements p {
    private c nAw = new c();
    private com.tencent.mm.sdk.b.c<bd> nAx = new 1(this);
    private com.tencent.mm.sdk.b.c<bc> nAy = new com.tencent.mm.sdk.b.c<bc>(this) {
        final /* synthetic */ a nAz;

        {
            this.nAz = r2;
            this.xen = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bc bcVar = (bc) bVar;
            if (29 == bcVar.fpl.fpm && bcVar.fpl.fpp) {
                x.d("Tinker.HotPatchApplication", "hp_res received new/updated download resource, path=%s", new Object[]{bcVar.fpl.filePath});
                com.tencent.mm.plugin.hp.b.b.ri(0);
                c.Cw(bcVar.fpl.filePath);
            }
            return false;
        }
    };

    public a() {
        d.aSD();
        d.a(MMApplicationLike.getTinkerApplicationLike());
        com.tencent.mm.sdk.b.a.xef.b(this.nAw);
        com.tencent.mm.sdk.b.a.xef.b(this.nAy);
        com.tencent.mm.sdk.b.a.xef.b(this.nAx);
    }

    public final void a(n nVar) {
    }

    public final void a(m mVar) {
    }
}
