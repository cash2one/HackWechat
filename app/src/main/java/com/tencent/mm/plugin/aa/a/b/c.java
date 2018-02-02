package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.g.b.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class c extends b {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "billNo";
        aVar.xjA.put("billNo", "TEXT PRIMARY KEY ");
        stringBuilder.append(" billNo TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "billNo";
        aVar.columns[1] = "insertmsg";
        aVar.xjA.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "localMsgId";
        aVar.xjA.put("localMsgId", "LONG");
        stringBuilder.append(" localMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
