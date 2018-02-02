package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.g.b.ck;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class r extends ck {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqkey";
        aVar.xjA.put("reqkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "reqkey";
        aVar.columns[1] = "ack_key";
        aVar.xjA.put("ack_key", "TEXT");
        stringBuilder.append(" ack_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "receive_time";
        aVar.xjA.put("receive_time", "LONG");
        stringBuilder.append(" receive_time LONG");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
