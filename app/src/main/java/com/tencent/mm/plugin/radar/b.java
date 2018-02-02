package com.tencent.mm.plugin.radar;

import b.c.b.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;

public final class b implements p {
    private static n ifs;
    private static m ift;
    public static final a pws = new a((byte) 0);

    public final void a(n nVar) {
        e.i(nVar, "callback");
        ifs = nVar;
    }

    public final void a(m mVar) {
        e.i(mVar, "callback");
        ift = mVar;
    }
}
