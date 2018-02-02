package com.tencent.mm.plugin.h;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class c extends a {
    public final void execute(g gVar) {
        k.b("tencentloc", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-tencentloc-library";
    }
}
