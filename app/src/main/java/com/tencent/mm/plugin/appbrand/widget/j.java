package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.g.b.cd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends cd {
    public static final a iEJ;

    static {
        a aVar = new a();
        aVar.hSY = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.xjA.put("appIdHash", "INTEGER");
        stringBuilder.append(" appIdHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pkgType";
        aVar.xjA.put("pkgType", "INTEGER");
        stringBuilder.append(" pkgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "widgetType";
        aVar.xjA.put("widgetType", "INTEGER");
        stringBuilder.append(" widgetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "launchAction";
        aVar.xjA.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "jsApiInfo";
        aVar.xjA.put("jsApiInfo", "BLOB");
        stringBuilder.append(" jsApiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "versionInfo";
        aVar.xjA.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "widgetSetting";
        aVar.xjA.put("widgetSetting", "BLOB");
        stringBuilder.append(" widgetSetting BLOB");
        aVar.columns[8] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iEJ = aVar;
    }

    protected final a Ac() {
        return iEJ;
    }
}
