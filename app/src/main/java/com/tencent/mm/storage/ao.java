package com.tencent.mm.storage;

import com.tencent.mm.g.b.bn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ao extends bn {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "originSvrId";
        aVar.xjA.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "originSvrId";
        aVar.columns[1] = "newMsgId";
        aVar.xjA.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "fromUserName";
        aVar.xjA.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUserName";
        aVar.xjA.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xjA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "content";
        aVar.xjA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgSource";
        aVar.xjA.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "msgSeq";
        aVar.xjA.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "flag";
        aVar.xjA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xjA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xjA.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xjA.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.xjA.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        aVar.columns[13] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
