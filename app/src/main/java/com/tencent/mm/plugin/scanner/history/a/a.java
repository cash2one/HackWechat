package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.mm.g.b.cw;
import java.lang.reflect.Field;

public final class a extends cw {
    protected static com.tencent.mm.sdk.e.c.a gJc;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productId";
        aVar.xjA.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "productId";
        aVar.columns[1] = "xmlContent";
        aVar.xjA.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "ScanTime";
        aVar.xjA.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "funcType";
        aVar.xjA.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "qrcodeUrl";
        aVar.xjA.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "scene";
        aVar.xjA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }
}
