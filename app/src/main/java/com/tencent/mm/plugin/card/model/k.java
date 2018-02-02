package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.b.ad;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

public final class k extends ad {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "code_id";
        aVar.xjA.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "card_id";
        aVar.xjA.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        aVar.xjA.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
