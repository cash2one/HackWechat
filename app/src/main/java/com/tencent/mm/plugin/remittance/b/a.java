package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.g.b.ak;
import java.lang.reflect.Field;

public final class a extends ak {
    public static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "transferId";
        aVar.xjA.put("transferId", "TEXT");
        stringBuilder.append(" transferId TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
