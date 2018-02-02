package com.tencent.mm.storage;

import com.tencent.mm.g.b.ag;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends ag {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xjA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "username";
        aVar.columns[1] = "cmdbuf";
        aVar.xjA.put("cmdbuf", "BLOB default '' ");
        stringBuilder.append(" cmdbuf BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
