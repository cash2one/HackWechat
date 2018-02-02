package com.tencent.mm.r;

import com.tencent.mm.g.b.bi;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class d extends bi {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cgi";
        aVar.xjA.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cmdid";
        aVar.xjA.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "functionmsgid";
        aVar.xjA.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "functionmsgid";
        aVar.columns[3] = "version";
        aVar.xjA.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "preVersion";
        aVar.xjA.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryinterval";
        aVar.xjA.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportid";
        aVar.xjA.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "successkey";
        aVar.xjA.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "failkey";
        aVar.xjA.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "finalfailkey";
        aVar.xjA.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "custombuff";
        aVar.xjA.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "addMsg";
        aVar.xjA.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "needShow";
        aVar.xjA.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        aVar.columns[14] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void b(bw bwVar) {
        if (bwVar != null) {
            this.field_addMsg = bwVar;
        }
    }
}
