package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.g.b.ef;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class ae extends ef {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xjA.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "recordId";
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "domin";
        aVar.xjA.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "key";
        aVar.xjA.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
