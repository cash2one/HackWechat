package com.tencent.mm.modelvideo;

import com.tencent.mm.g.b.db;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class j extends db {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xjA.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "localId";
        aVar.columns[1] = DownloadInfo.FILENAME;
        aVar.xjA.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileNameHash";
        aVar.xjA.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileMd5";
        aVar.xjA.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileLength";
        aVar.xjA.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "fileStatus";
        aVar.xjA.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileDuration";
        aVar.xjA.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.xjA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.columns[8] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
