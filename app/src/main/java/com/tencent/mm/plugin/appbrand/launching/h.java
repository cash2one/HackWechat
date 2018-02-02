package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.b.al;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends al {
    static final String[] iEI = new String[]{"appId", "versionType"};
    static final a iEJ;

    protected final a Ac() {
        return null;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "versionType";
        aVar.xjA.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "extJson";
        aVar.xjA.put("extJson", "TEXT");
        stringBuilder.append(" extJson TEXT");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iEJ = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = iEI;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = iEJ;
        aVar2.xjB = stringBuilder2.append(aVar2.xjB).append(",").append(str2).toString();
    }
}
