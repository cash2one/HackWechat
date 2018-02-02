package com.tencent.mm.plugin.order.b;

import com.tencent.mm.g.b.cm;
import java.lang.reflect.Field;

public final class a extends cm {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "msgContentXml";
        aVar.xjA.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xjA.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
