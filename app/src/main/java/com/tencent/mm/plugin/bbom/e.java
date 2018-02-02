package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bm.c;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.z.p;

public final class e extends p implements b {
    public e() {
        super(c.Tc("search"));
    }

    public final void parallelsDependency() {
        a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.k(m.class));
    }
}
