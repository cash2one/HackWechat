package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelsfs.FileOp;

public final class c extends a {
    public final void execute(g gVar) {
        FileOp.init(gVar.DS());
    }

    public final String name() {
        return "boot-sfs";
    }
}
