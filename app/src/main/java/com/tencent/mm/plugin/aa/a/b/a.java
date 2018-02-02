package com.tencent.mm.plugin.aa.a.b;

import java.lang.reflect.Field;

public final class a extends com.tencent.mm.g.b.a {
    public static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "payMsgId";
        aVar.xjA.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "payMsgId";
        aVar.columns[1] = "insertmsg";
        aVar.xjA.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "chatroom";
        aVar.xjA.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgId";
        aVar.xjA.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
