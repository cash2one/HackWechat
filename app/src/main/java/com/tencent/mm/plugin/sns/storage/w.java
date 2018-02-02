package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.g.b.do;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class w extends do {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.xjA.put("canvasId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" canvasId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.xjA.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "canvasExt";
        aVar.xjA.put("canvasExt", "TEXT");
        stringBuilder.append(" canvasExt TEXT");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
