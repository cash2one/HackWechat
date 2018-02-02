package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class o extends i<n> {
    public static final String[] fMK = new String[0];
    public static final String[] gJN = new String[]{i.a(n.gJc, "shaketvhistory")};
    public e gJP;

    public o(e eVar) {
        super(eVar, n.gJc, "shaketvhistory", gJN);
        this.gJP = eVar;
    }

    public final Cursor bsi() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime").append(" DESC");
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }
}
