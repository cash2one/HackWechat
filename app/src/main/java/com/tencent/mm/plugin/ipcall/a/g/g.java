package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.b.bw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends bw {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrId";
        aVar.xjA.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "svrId";
        aVar.columns[1] = "isRead";
        aVar.xjA.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "content";
        aVar.xjA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pushTime";
        aVar.xjA.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgType";
        aVar.xjA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "descUrl";
        aVar.xjA.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
