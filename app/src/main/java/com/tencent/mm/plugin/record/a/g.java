package com.tencent.mm.plugin.record.a;

import com.tencent.mm.g.b.cs;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class g extends cs implements b {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xjA.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "localId";
        aVar.columns[1] = "msgId";
        aVar.xjA.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "oriMsgId";
        aVar.xjA.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUser";
        aVar.xjA.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "desc";
        aVar.xjA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "dataProto";
        aVar.xjA.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "favFrom";
        aVar.xjA.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        aVar.columns[10] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final int bmL() {
        return this.field_localId;
    }
}
