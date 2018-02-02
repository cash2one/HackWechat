package com.tencent.mm.plugin.report.a;

import com.tencent.mm.g.b.am;
import java.lang.reflect.Field;

public final class a extends am {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bakLogId";
        aVar.xjA.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "valueStr";
        aVar.xjA.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
