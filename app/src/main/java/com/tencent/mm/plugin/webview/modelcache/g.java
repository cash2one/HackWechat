package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.g.b.ea;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

final class g extends ea {
    protected static a gJc;

    g() {
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "disable";
        aVar.xjA.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "configId";
        aVar.xjA.put("configId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" configId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "configId";
        aVar.columns[2] = "configUrl";
        aVar.xjA.put("configUrl", "TEXT");
        stringBuilder.append(" configUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "configResources";
        aVar.xjA.put("configResources", "TEXT");
        stringBuilder.append(" configResources TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "configCrc32";
        aVar.xjA.put("configCrc32", "LONG");
        stringBuilder.append(" configCrc32 LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isFromXml";
        aVar.xjA.put("isFromXml", "INTEGER default 'false' ");
        stringBuilder.append(" isFromXml INTEGER default 'false' ");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
