package com.tencent.mm.storage;

import com.tencent.mm.g.b.dq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.reflect.Field;

public final class bl extends dq {
    protected static a gJc;

    protected final a Ac() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "cmsgId";
        aVar.xjA.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "content";
        aVar.xjA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public final void XN(String str) {
        if (!bh.ov(str)) {
            this.field_cmsgId = str;
        }
    }
}
