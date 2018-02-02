package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.as;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends as {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "designerIDAndType";
        aVar.xjA.put("designerIDAndType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "designerIDAndType";
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
