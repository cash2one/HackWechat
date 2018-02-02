package com.tencent.mm.pluginsdk.i.a.d;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.cu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class q extends cu {
    public static final a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[34];
        aVar.columns = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlKey_hashcode";
        aVar.xjA.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "urlKey_hashcode";
        aVar.columns[1] = "urlKey";
        aVar.xjA.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xjA.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileVersion";
        aVar.xjA.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "networkType";
        aVar.xjA.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "maxRetryTimes";
        aVar.xjA.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "retryTimes";
        aVar.xjA.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfoColumns.FILEPATH;
        aVar.xjA.put(DownloadInfoColumns.FILEPATH, "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "contentLength";
        aVar.xjA.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = DownloadInfo.CONTENTTYPE;
        aVar.xjA.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.xjA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "md5";
        aVar.xjA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "groupId1";
        aVar.xjA.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId2";
        aVar.xjA.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadInfo.PRIORITY;
        aVar.xjA.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "fileUpdated";
        aVar.xjA.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleted";
        aVar.xjA.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "resType";
        aVar.xjA.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "subType";
        aVar.xjA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[20] = "reportId";
        aVar.xjA.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        aVar.columns[21] = "sampleId";
        aVar.xjA.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "eccSignature";
        aVar.xjA.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        aVar.columns[23] = "originalMd5";
        aVar.xjA.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "fileCompress";
        aVar.xjA.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "fileEncrypt";
        aVar.xjA.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[26] = "encryptKey";
        aVar.xjA.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "keyVersion";
        aVar.xjA.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "EID";
        aVar.xjA.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "fileSize";
        aVar.xjA.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        aVar.columns[30] = "needRetry";
        aVar.xjA.put("needRetry", "INTEGER default '1' ");
        stringBuilder.append(" needRetry INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[31] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "wvCacheType";
        aVar.xjA.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[33] = "packageId";
        aVar.xjA.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        aVar.columns[34] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e22, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }

    protected final a Ac() {
        return gJc;
    }
}
