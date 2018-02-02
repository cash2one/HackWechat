package com.tencent.mm.storage;

import com.tencent.mm.g.b.dl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bh extends dl {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tableHash";
        aVar.xjA.put("tableHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "tableHash";
        aVar.columns[1] = "tableSQLMD5";
        aVar.xjA.put("tableSQLMD5", "TEXT");
        stringBuilder.append(" tableSQLMD5 TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
