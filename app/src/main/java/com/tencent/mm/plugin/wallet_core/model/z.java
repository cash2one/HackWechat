package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.b.dw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends dw {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pref_key";
        aVar.xjA.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "pref_key";
        aVar.columns[1] = "pref_title";
        aVar.xjA.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pref_url";
        aVar.xjA.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show";
        aVar.xjA.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
