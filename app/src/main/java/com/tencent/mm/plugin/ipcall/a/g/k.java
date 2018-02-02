package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.b.by;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class k extends by {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "phonenumber";
        aVar.xjA.put("phonenumber", "TEXT");
        stringBuilder.append(" phonenumber TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "calltime";
        aVar.xjA.put("calltime", "LONG");
        stringBuilder.append(" calltime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        aVar.xjA.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "addressId";
        aVar.xjA.put("addressId", "LONG default '-1' ");
        stringBuilder.append(" addressId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "phoneType";
        aVar.xjA.put("phoneType", "INTEGER default '-1' ");
        stringBuilder.append(" phoneType INTEGER default '-1' ");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
