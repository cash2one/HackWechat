package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.b.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class q extends cp {
    static final String[] iEI = new String[]{"key", "version"};
    static final a iEJ;

    protected final a Ac() {
        return iEJ;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xjA.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xjA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "scene";
        aVar.xjA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[4] = "rowid";
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
