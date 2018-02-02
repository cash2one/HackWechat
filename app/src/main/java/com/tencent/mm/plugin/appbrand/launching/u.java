package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.b.cc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class u extends cc {
    static final a iEJ;
    public transient boolean jxH;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
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
        aVar.columns[2] = "launchAction";
        aVar.xjA.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "jsapiInfo";
        aVar.xjA.put("jsapiInfo", "BLOB");
        stringBuilder.append(" jsapiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "hostInfo";
        aVar.xjA.put("hostInfo", "BLOB");
        stringBuilder.append(" hostInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionsheetInfo";
        aVar.xjA.put("actionsheetInfo", "BLOB");
        stringBuilder.append(" actionsheetInfo BLOB");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iEJ = aVar;
    }

    protected final a Ac() {
        return iEJ;
    }
}
