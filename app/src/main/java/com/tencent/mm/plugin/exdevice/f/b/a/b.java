package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.b.bs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bs {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.xjA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "score";
        aVar.xjA.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
