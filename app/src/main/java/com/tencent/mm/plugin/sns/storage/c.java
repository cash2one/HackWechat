package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.g.b.aa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends aa {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.xjA.put("canvasId", "LONG PRIMARY KEY ");
        stringBuilder.append(" canvasId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.xjA.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
