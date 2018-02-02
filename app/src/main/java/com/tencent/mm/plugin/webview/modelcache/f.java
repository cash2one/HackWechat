package com.tencent.mm.plugin.webview.modelcache;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.ee;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class f extends ee {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlMd5Hashcode";
        aVar.xjA.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xjA.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "domain";
        aVar.xjA.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "version";
        aVar.xjA.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPath";
        aVar.xjA.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.CONTENTTYPE;
        aVar.xjA.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "contentLength";
        aVar.xjA.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "isLatestVersion";
        aVar.xjA.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "accessTime";
        aVar.xjA.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.xjA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "cacheType";
        aVar.xjA.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "configId";
        aVar.xjA.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "protocol";
        aVar.xjA.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "packageId";
        aVar.xjA.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentMd5";
        aVar.xjA.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        aVar.columns[17] = "rowid";
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
            x.printErrStackTrace("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
