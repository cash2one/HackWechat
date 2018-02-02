package com.tencent.mm.storage;

import com.tencent.mm.g.b.cl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class ba extends cl {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "appId";
        aVar.columns[1] = DownloadInfoColumns.PACKAGENAME;
        aVar.xjA.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "sceneFlag";
        aVar.xjA.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "msgTypeFlag";
        aVar.xjA.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgState";
        aVar.xjA.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
