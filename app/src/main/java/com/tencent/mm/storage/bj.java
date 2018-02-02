package com.tencent.mm.storage;

import com.tencent.mm.g.b.dn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bj extends dn {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.xjA.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "openId";
        aVar.columns[1] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        aVar.columns[3] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public bj(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }
}
