package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.g.b.dv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends dv {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mNativeUrl";
        aVar.xjA.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "mNativeUrl";
        aVar.columns[1] = "hbType";
        aVar.xjA.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveAmount";
        aVar.xjA.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "receiveTime";
        aVar.xjA.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "receiveStatus";
        aVar.xjA.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hbStatus";
        aVar.xjA.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
