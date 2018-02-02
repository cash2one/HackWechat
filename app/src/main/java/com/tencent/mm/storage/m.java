package com.tencent.mm.storage;

import com.tencent.mm.g.b.s;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends s {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "sessionName";
        aVar.xjA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "startTime";
        aVar.xjA.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "endTime";
        aVar.xjA.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
