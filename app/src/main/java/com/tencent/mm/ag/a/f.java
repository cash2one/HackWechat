package com.tencent.mm.ag.a;

import com.tencent.mm.g.b.v;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends v {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "brandUserName";
        aVar.xjA.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "brandUserName";
        aVar.columns[1] = "userId";
        aVar.xjA.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
