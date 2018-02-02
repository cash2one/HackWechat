package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.b.cq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class s extends cq {
    static final String[] iEI = new String[]{"appId", DownloadSettingTable$Columns.TYPE};
    static final a iEJ;

    static {
        int i = 0;
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "hit";
        aVar.xjA.put("hit", "INTEGER");
        stringBuilder.append(" hit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "hitTimeMS";
        aVar.xjA.put("hitTimeMS", "LONG");
        stringBuilder.append(" hitTimeMS LONG");
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

    protected final a Ac() {
        return iEJ;
    }
}
