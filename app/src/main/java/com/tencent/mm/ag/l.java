package com.tencent.mm.ag;

import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l implements o, b, com.tencent.mm.kernel.api.bucket.b, c {
    private o hpV;
    private p hpW;

    public final o Fb() {
        return this.hpV;
    }

    public final p Fc() {
        return this.hpW;
    }

    public final String Fv() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("brandicon/").toString();
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
        com.tencent.mm.plugin.messenger.foundation.a.a.c aZi = ((h) g.h(h.class)).aZi();
        com.tencent.mm.storage.e oVar = new o(aZi);
        this.hpV = oVar;
        aZi.a(oVar);
        this.hpW = new p(((h) g.h(h.class)).Fd());
    }

    public final void onAccountRelease() {
    }

    public final void parallelsDependency() {
        a.a(this, c.class).aJ(g.k(n.class));
    }
}
