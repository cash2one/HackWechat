package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.p;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends p {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "flag";
        aVar.xjA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "sortId";
        aVar.xjA.put("sortId", "INTEGER default '0' ");
        stringBuilder.append(" sortId INTEGER default '0' ");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
