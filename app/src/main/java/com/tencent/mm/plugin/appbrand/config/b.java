package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.g.b.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class b extends h {
    public static final a iGc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xjA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "key";
        aVar.columns[1] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iGc = aVar;
    }

    protected final a Ac() {
        return iGc;
    }
}
