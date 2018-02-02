package com.tencent.mm.sandbox.updater;

import com.tencent.mm.g.a.sf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class h extends c<sf> {
    public h() {
        this.xen = sf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sf sfVar = (sf) bVar;
        if (sfVar instanceof sf) {
            Updater c = Updater.c(sfVar.fJU.context, null);
            if (c != null) {
                c.ab(sfVar.fJU.type, true);
            }
        }
        return false;
    }
}
