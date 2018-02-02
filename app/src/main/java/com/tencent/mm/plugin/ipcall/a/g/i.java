package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.b.bx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends bx {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "countryCode";
        aVar.xjA.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "countryCode";
        aVar.columns[1] = "callTimeCount";
        aVar.xjA.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "lastCallTime";
        aVar.xjA.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
