package com.tencent.mm.g.b;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bz extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int ggP = "logId".hashCode();
    private static final int ggQ = "liftTime".hashCode();
    public long field_liftTime;
    public int field_logId;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logId";
        aVar.xjA.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "logId";
        aVar.columns[1] = "liftTime";
        aVar.xjA.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }
}
