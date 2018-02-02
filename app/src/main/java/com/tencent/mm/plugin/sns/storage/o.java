package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.b.dh;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class o extends dh {
    protected static a gJc;
    public int roJ;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logtime";
        aVar.xjA.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "offset";
        aVar.xjA.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "logsize";
        aVar.xjA.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "errorcount";
        aVar.xjA.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadSettingTable$Columns.VALUE;
        aVar.xjA.put(DownloadSettingTable$Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.roJ = (int) this.xjy;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsKvReport", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.bvA().byd();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
        }
    }
}
