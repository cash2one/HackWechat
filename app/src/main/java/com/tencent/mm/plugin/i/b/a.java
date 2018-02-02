package com.tencent.mm.plugin.i.b;

import android.database.Cursor;
import com.tencent.mm.g.b.ei;
import java.lang.reflect.Field;

public final class a extends ei {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgType";
        aVar.xjA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgSubType";
        aVar.xjA.put("msgSubType", "INTEGER");
        stringBuilder.append(" msgSubType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "path";
        aVar.xjA.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "size";
        aVar.xjA.put("size", "LONG");
        stringBuilder.append(" size LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgtime";
        aVar.xjA.put("msgtime", "LONG");
        stringBuilder.append(" msgtime LONG");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }

    public final String toString() {
        return "{  sys row id: " + this.xjy + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
    }
}
