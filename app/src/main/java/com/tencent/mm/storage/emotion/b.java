package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.aq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends aq {
    protected static a gJc;

    protected final a Ac() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5_lang";
        aVar.xjA.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xjz = "md5_lang";
        aVar.columns[1] = "md5";
        aVar.xjA.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lang";
        aVar.xjA.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[3] = "desc";
        aVar.xjA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "groupId";
        aVar.xjA.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "click_flag";
        aVar.xjA.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "download_flag";
        aVar.xjA.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public final String Nr() {
        return this.field_md5 == null ? "" : this.field_md5;
    }
}
