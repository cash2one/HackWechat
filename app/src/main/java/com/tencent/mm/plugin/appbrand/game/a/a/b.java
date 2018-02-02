package com.tencent.mm.plugin.appbrand.game.a.a;

import com.tencent.mm.g.b.el;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends el {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "RecordId";
        aVar.xjA.put("RecordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" RecordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "RecordId";
        aVar.columns[1] = "AppId";
        aVar.xjA.put("AppId", "TEXT");
        stringBuilder.append(" AppId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "AppName";
        aVar.xjA.put("AppName", "TEXT");
        stringBuilder.append(" AppName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "UserName";
        aVar.xjA.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "IconUrl";
        aVar.xjA.put("IconUrl", "TEXT");
        stringBuilder.append(" IconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "BriefIntro";
        aVar.xjA.put("BriefIntro", "TEXT");
        stringBuilder.append(" BriefIntro TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSync";
        aVar.xjA.put("isSync", "INTEGER default 'false' ");
        stringBuilder.append(" isSync INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.xjA.put("debugType", "INTEGER");
        stringBuilder.append(" debugType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[9] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
