package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.g.b.bm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class o extends bm {
    public static a gJc;

    protected final a Ac() {
        return null;
    }

    public o(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public o(Cursor cursor) {
        if (cursor != null) {
            b(cursor);
        }
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqType";
        aVar.xjA.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "reqType";
        aVar.columns[1] = "cache";
        aVar.xjA.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }
}
