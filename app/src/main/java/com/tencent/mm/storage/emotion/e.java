package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.ar;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends ar {
    protected static a gJc;

    public e(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    protected final a Ac() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "groupID";
        aVar.xjA.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "desc";
        aVar.xjA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }
}
