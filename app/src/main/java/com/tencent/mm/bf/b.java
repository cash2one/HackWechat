package com.tencent.mm.bf;

import com.tencent.mm.g.b.aw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends aw {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "talker";
        aVar.xjA.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "talker";
        aVar.columns[1] = "encryptTalker";
        aVar.xjA.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "displayName";
        aVar.xjA.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "state";
        aVar.xjA.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastModifiedTime";
        aVar.xjA.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isNew";
        aVar.xjA.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "addScene";
        aVar.xjA.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "fmsgSysRowId";
        aVar.xjA.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "fmsgIsSend";
        aVar.xjA.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "fmsgType";
        aVar.xjA.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "fmsgContent";
        aVar.xjA.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "recvFmsgType";
        aVar.xjA.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "contentFromUsername";
        aVar.xjA.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "contentNickname";
        aVar.xjA.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contentPhoneNumMD5";
        aVar.xjA.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "contentFullPhoneNumMD5";
        aVar.xjA.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentVerifyContent";
        aVar.xjA.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        aVar.columns[17] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
