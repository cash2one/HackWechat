package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;

class f$d extends a {
    final /* synthetic */ f mOg;

    private f$d(f fVar) {
        this.mOg = fVar;
    }

    public final boolean execute() {
        g.Dj().gQj.fx(null, "UPDATE rconversation SET unReadCount = 0;");
        return true;
    }

    public final String getName() {
        return "FTSClearUnReadCountTask";
    }
}
