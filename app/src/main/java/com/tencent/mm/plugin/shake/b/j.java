package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.plugin.shake.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends b {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xjA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "username";
        aVar.columns[1] = "lastshaketime";
        aVar.xjA.put("lastshaketime", "INTEGER default '0' ");
        stringBuilder.append(" lastshaketime INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "isshowed";
        aVar.xjA.put("isshowed", "INTEGER default 'false' ");
        stringBuilder.append(" isshowed INTEGER default 'false' ");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
