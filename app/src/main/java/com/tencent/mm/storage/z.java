package com.tencent.mm.storage;

import com.tencent.mm.g.b.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends ah {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelID";
        aVar.xjA.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "labelID";
        aVar.columns[1] = "labelName";
        aVar.xjA.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "labelPYFull";
        aVar.xjA.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "labelPYShort";
        aVar.xjA.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isTemporary";
        aVar.xjA.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
