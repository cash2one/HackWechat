package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.b.bp;
import java.lang.reflect.Field;

public final class a extends bp {
    public static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "championUrl";
        aVar.xjA.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "championMotto";
        aVar.xjA.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
