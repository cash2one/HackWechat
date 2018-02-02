package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;

class c$b extends a {
    private int mCount;
    final /* synthetic */ c mNG;

    private c$b(c cVar) {
        this.mNG = cVar;
        this.mCount = 0;
    }

    public final boolean execute() {
        this.mCount = this.mNG.mNy.e(c.mKa, -1).size();
        return true;
    }

    public final String ado() {
        return String.format("{mCount: %d}", new Object[]{Integer.valueOf(this.mCount)});
    }

    public final String getName() {
        return "DeleteAllTask";
    }
}
