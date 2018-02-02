package com.tencent.mm.y;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public class o extends cf {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.xjA.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isSend";
        aVar.xjA.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "isShowTimer";
        aVar.xjA.put("isShowTimer", "INTEGER");
        stringBuilder.append(" isShowTimer INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "talker";
        aVar.xjA.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.xjA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgPath";
        aVar.xjA.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved";
        aVar.xjA.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "lvbuffer";
        aVar.xjA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "talkerId";
        aVar.xjA.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "transContent";
        aVar.xjA.put("transContent", "TEXT default '' ");
        stringBuilder.append(" transContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "transBrandWording";
        aVar.xjA.put("transBrandWording", "TEXT default '' ");
        stringBuilder.append(" transBrandWording TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "bizClientMsgId";
        aVar.xjA.put("bizClientMsgId", "TEXT default '' ");
        stringBuilder.append(" bizClientMsgId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "bizChatId";
        aVar.xjA.put("bizChatId", "LONG default '-1' ");
        stringBuilder.append(" bizChatId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "bizChatUserId";
        aVar.xjA.put("bizChatUserId", "TEXT default '' ");
        stringBuilder.append(" bizChatUserId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "msgSeq";
        aVar.xjA.put("msgSeq", "LONG");
        stringBuilder.append(" msgSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "flag";
        aVar.xjA.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
