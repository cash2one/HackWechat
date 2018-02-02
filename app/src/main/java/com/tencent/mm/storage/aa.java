package com.tencent.mm.storage;

import com.tencent.mm.g.b.ai;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class aa extends ai {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelId";
        aVar.xjA.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "contactName";
        aVar.xjA.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
