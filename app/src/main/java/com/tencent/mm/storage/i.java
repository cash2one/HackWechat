package com.tencent.mm.storage;

import com.tencent.mm.g.b.q;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends q {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceId";
        aVar.xjA.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "sessionName";
        aVar.xjA.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "moveTime";
        aVar.xjA.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
