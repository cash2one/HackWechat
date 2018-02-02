package com.tencent.mm.m;

import com.tencent.mm.g.b.aj;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class a extends aj {
    public static com.tencent.mm.sdk.e.c.a gJc;
    public static final String gJf = null;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgCount";
        aVar.xjA.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.xjA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "username";
        aVar.columns[2] = "unReadCount";
        aVar.xjA.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatmode";
        aVar.xjA.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isSend";
        aVar.xjA.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "conversationTime";
        aVar.xjA.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "content";
        aVar.xjA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "msgType";
        aVar.xjA.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "customNotify";
        aVar.xjA.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showTips";
        aVar.xjA.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "flag";
        aVar.xjA.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "digest";
        aVar.xjA.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "digestUser";
        aVar.xjA.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hasTrunc";
        aVar.xjA.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "parentRef";
        aVar.xjA.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrflag";
        aVar.xjA.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "editingMsg";
        aVar.xjA.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "atCount";
        aVar.xjA.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "sightTime";
        aVar.xjA.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "unReadMuteCount";
        aVar.xjA.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "lastSeq";
        aVar.xjA.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[22] = "UnDeliverCount";
        aVar.xjA.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "UnReadInvite";
        aVar.xjA.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "firstUnDeliverSeq";
        aVar.xjA.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.columns[25] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public a(String str) {
        setUsername(str);
    }

    public final void gb(int i) {
        eT(this.field_attrflag | i);
    }

    public final void AU() {
        eT(this.field_attrflag & -16777217);
    }

    public final boolean gc(int i) {
        return (this.field_attrflag & i) != 0;
    }
}
