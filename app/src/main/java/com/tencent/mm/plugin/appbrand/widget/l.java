package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.g.b.ek;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class l extends ek {
    public static a iGc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.xjA.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "openDebug";
        aVar.xjA.put("openDebug", "INTEGER");
        stringBuilder.append(" openDebug INTEGER");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iGc = aVar;
    }

    protected final a Ac() {
        return iGc;
    }
}
