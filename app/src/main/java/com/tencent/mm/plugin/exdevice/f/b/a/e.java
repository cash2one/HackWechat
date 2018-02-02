package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.b.br;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends br {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.xjA.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.xjA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "timestamp";
        aVar.xjA.put("timestamp", "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "liketips";
        aVar.xjA.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
