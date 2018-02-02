package com.tencent.mm.plugin.search.a;

import com.tencent.mm.g.a.ry;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;

class c$4 extends a {
    final /* synthetic */ c qbq;
    String qbr = w.eL(ac.getContext());
    boolean qbs = false;

    c$4(c cVar) {
        this.qbq = cVar;
    }

    public final boolean execute() {
        this.qbs = ((int) ((m) g.k(m.class)).getFTSIndexDB().s(-3, 0)) != this.qbr.hashCode();
        if (this.qbs) {
            com.tencent.mm.sdk.b.a.xef.m(new ry());
        }
        return true;
    }

    public final String ado() {
        return String.format("{changed: %b}", new Object[]{Boolean.valueOf(this.qbs)});
    }

    public final String getName() {
        return "CheckLanguageUpdate";
    }
}
