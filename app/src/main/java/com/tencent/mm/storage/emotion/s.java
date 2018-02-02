package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.dd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class s extends dd {
    protected static a gJc;

    protected final a Ac() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xjA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "key";
        aVar.columns[1] = "position";
        aVar.xjA.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public s(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        return stringBuilder.toString();
    }
}
