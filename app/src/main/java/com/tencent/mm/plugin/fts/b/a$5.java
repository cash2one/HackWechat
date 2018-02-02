package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.sc;
import com.tencent.mm.plugin.fts.b.a.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class a$5 extends c<sc> {
    final /* synthetic */ a mMS;

    a$5(a aVar) {
        this.mMS = aVar;
        this.xen = sc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sc scVar = (sc) bVar;
        if (scVar.fJP.fpS <= 0) {
            a.e(this.mMS).a(131093, new u(this.mMS, (byte) 0));
        } else if (a.h(this.mMS).cfK()) {
            ak h = a.h(this.mMS);
            long j = scVar.fJP.fpS;
            h.J(j, j);
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
        }
        return false;
    }
}
