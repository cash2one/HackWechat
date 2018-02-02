package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends av {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "prodcutID";
        aVar.xjA.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "prodcutID";
        aVar.columns[1] = "totalCount";
        aVar.xjA.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "continuCount";
        aVar.xjA.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "flag";
        aVar.xjA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "modifyTime";
        aVar.xjA.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "showTipsTime";
        aVar.xjA.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "setFlagTime";
        aVar.xjA.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return null;
    }
}
