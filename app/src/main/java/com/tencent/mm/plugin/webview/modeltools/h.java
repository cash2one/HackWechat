package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.b.ed;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends ed {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "host";
        aVar.xjA.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "expireTime";
        aVar.xjA.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
