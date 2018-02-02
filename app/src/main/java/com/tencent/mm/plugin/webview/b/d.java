package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.g.b.ec;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends ec {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xjA.put("recordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" recordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "recordId";
        aVar.columns[1] = "link";
        aVar.xjA.put("link", "TEXT");
        stringBuilder.append(" link TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "source";
        aVar.xjA.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "imgUrl";
        aVar.xjA.put("imgUrl", "TEXT");
        stringBuilder.append(" imgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xjA.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
