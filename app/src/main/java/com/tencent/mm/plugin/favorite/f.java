package com.tencent.mm.plugin.favorite;

import com.tencent.mm.a.n;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.plugin.favorite.a.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class f extends c<fu> {
    public f() {
        this.xen = fu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fu fuVar = (fu) bVar;
        x.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (h.aIn().flR) {
            x.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
        } else {
            byte[] bArr = fuVar.fvo.fvp;
            ar.CG().a(new p(bArr == null ? 1 : n.p(bArr, 0)), 0);
        }
        return false;
    }
}
