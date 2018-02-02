package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.g.b.m;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ae extends m {
    public static final String[] iGb = new String[]{"appId", "version", "debugType"};
    static final a iGc;

    static {
        int i = 0;
        a aVar = new a();
        aVar.hSY = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xjA.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionMd5";
        aVar.xjA.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "versionState";
        aVar.xjA.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.xjA.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "resourceCount";
        aVar.xjA.put("resourceCount", "INTEGER");
        stringBuilder.append(" resourceCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.xjA.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "downloadURL";
        aVar.xjA.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "startTime";
        aVar.xjA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "endTime";
        aVar.xjA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[11] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iGc = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = iGb;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = iGc;
        aVar2.xjB = stringBuilder2.append(aVar2.xjB).append(",").append(str2).toString();
    }

    protected final a Ac() {
        return iGc;
    }
}
