package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.c.c;

class c$d extends a {
    private String jRw;
    final /* synthetic */ c mNG;

    public c$d(c cVar, String str) {
        this.mNG = cVar;
        this.jRw = str;
    }

    public final boolean execute() {
        c cVar = this.mNG.mNy;
        String str = this.jRw;
        cVar.mOs.bindLong(1, -1);
        cVar.mOs.bindString(2, str);
        cVar.mOs.bindLong(3, -1);
        cVar.mOs.execute();
        return true;
    }

    public final String ado() {
        return String.format("{conversation: %s}", new Object[]{this.jRw});
    }

    public final String getName() {
        return "DeleteTalkerTask";
    }
}
