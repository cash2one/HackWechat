package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.g.b.eb;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class a extends eb {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appIdKey";
        aVar.xjA.put("appIdKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "appIdKey";
        aVar.columns[2] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "weight";
        aVar.xjA.put("weight", "TEXT");
        stringBuilder.append(" weight TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expireTime";
        aVar.xjA.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xjA.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "size";
        aVar.xjA.put("size", "LONG");
        stringBuilder.append(" size LONG");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
