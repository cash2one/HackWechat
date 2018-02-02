package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends au {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.xjA.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "productID";
        aVar.columns[1] = "content";
        aVar.xjA.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return null;
    }
}
