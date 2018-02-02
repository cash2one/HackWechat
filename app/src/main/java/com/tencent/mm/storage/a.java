package com.tencent.mm.storage;

import com.tencent.mm.g.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class a extends c {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "abtestkey";
        aVar.xjA.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "abtestkey";
        aVar.columns[1] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.xjA.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.xjA.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.xjA.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.xjA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.xjA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "noReport";
        aVar.xjA.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        aVar.columns[8] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public final boolean isValid() {
        long Wo = bh.Wo();
        return Wo >= this.field_startTime && Wo < this.field_endTime;
    }
}
