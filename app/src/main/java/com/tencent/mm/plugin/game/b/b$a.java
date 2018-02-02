package com.tencent.mm.plugin.game.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;

class b$a extends a {
    private String appId;
    final /* synthetic */ b mVK;

    public b$a(b bVar, String str) {
        this.mVK = bVar;
        this.appId = str;
    }

    public final boolean execute() {
        this.mVK.mVJ.a(c.mKd, this.appId);
        return true;
    }

    public final String ado() {
        return String.format("{appId: %s}", new Object[]{this.appId});
    }

    public final String getName() {
        return "DeleteGameTask";
    }
}
