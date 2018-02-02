package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$e extends a {
    private String gAb;
    private boolean gJC = false;
    final /* synthetic */ a mMS;

    public a$e(a aVar, String str) {
        this.mMS = aVar;
        this.gAb = str;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[]{this.gAb});
        af AW = a.d(this.mMS).AW(this.gAb);
        if (AW == null || AW.field_username.length() <= 0 || !this.mMS.D(AW)) {
            this.gJC = true;
        } else {
            this.mMS.E(AW);
        }
        a.b(this.mMS).remove(this.gAb);
        a.c(this.mMS).remove(this.gAb);
        return true;
    }

    public final String ado() {
        return String.format("{username: %s isSkipped: %b}", new Object[]{this.gAb, Boolean.valueOf(this.gJC)});
    }

    public final String getName() {
        return "InsertContactTask";
    }
}
