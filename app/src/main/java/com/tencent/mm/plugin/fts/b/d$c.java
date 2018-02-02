package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.c.d;

public class d$c extends a {
    public String mNV;
    final /* synthetic */ d mNW;

    public d$c(d dVar) {
        this.mNW = dVar;
    }

    public final boolean execute() {
        d dVar = this.mNW.mNU;
        String str = this.mNV;
        dVar.mJR.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{d.aMR()}), new String[]{str});
        return true;
    }

    public final String getName() {
        return "DeleteSOSHistoryTask";
    }
}
