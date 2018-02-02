package com.tencent.mm.bf;

import com.tencent.mm.g.b.ax;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class f extends ax {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgContent";
        aVar.xjA.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "isSend";
        aVar.xjA.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "talker";
        aVar.xjA.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "encryptTalker";
        aVar.xjA.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "svrId";
        aVar.xjA.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xjA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatroomName";
        aVar.xjA.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        aVar.columns[8] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean To() {
        return this.field_isSend % 2 == 0;
    }
}
