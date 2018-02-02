package com.tencent.mm.plugin.favorite;

import com.tencent.mm.bm.c;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.z.p;

public final class a extends p implements b {
    public a() {
        super(c.Tc("favorite"));
    }

    public final void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.k(m.class));
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.k(r.class));
    }
}
