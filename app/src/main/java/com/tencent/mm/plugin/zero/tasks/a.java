package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.wcdb.support.Log;

public final class a extends com.tencent.mm.kernel.a.c.a {
    public final void execute(g gVar) {
        if (!k.eL("wcdb")) {
            k.b("wcdb", getClass().getClassLoader());
        }
        Log.setLogger(new 1(this));
    }

    public final String name() {
        return "boot-db-prepare";
    }
}
