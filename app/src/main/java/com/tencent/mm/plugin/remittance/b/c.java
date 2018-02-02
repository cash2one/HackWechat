package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.g.b.ct;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends ct {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "transferId";
        aVar.xjA.put("transferId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" transferId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "transferId";
        aVar.columns[1] = "locaMsgId";
        aVar.xjA.put("locaMsgId", "LONG");
        stringBuilder.append(" locaMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveStatus";
        aVar.xjA.put("receiveStatus", "INTEGER default '-1' ");
        stringBuilder.append(" receiveStatus INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "isSend";
        aVar.xjA.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
