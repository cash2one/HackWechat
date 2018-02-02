package com.tencent.mm.ag.a;

import com.tencent.mm.g.b.t;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class a extends t {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatId";
        aVar.xjA.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "bizChatId";
        aVar.columns[1] = "brandUserName";
        aVar.xjA.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "unReadCount";
        aVar.xjA.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "newUnReadCount";
        aVar.xjA.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastMsgID";
        aVar.xjA.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "lastMsgTime";
        aVar.xjA.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.xjA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "digest";
        aVar.xjA.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "digestUser";
        aVar.xjA.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "atCount";
        aVar.xjA.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "editingMsg";
        aVar.xjA.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatType";
        aVar.xjA.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "isSend";
        aVar.xjA.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgType";
        aVar.xjA.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "msgCount";
        aVar.xjA.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "flag";
        aVar.xjA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        aVar.columns[17] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
