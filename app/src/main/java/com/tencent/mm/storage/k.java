package com.tencent.mm.storage;

import com.tencent.mm.g.b.r;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends r {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgListDataId";
        aVar.xjA.put("msgListDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgListDataId";
        aVar.columns[1] = "sessionName";
        aVar.xjA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
