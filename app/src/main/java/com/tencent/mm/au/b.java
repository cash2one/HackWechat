package com.tencent.mm.au;

import com.tencent.mm.g.b.cg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends cg {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wxGroupId";
        aVar.xjA.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "wxGroupId";
        aVar.columns[1] = "groupId";
        aVar.xjA.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "roomId";
        aVar.xjA.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "roomKey";
        aVar.xjA.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "routeId";
        aVar.xjA.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "inviteUserName";
        aVar.xjA.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "memberCount";
        aVar.xjA.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "state";
        aVar.xjA.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        aVar.columns[9] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
