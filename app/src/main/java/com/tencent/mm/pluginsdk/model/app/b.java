package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class b extends g {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "sdkVer";
        aVar.xjA.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "mediaSvrId";
        aVar.xjA.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "mediaId";
        aVar.xjA.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "clientAppDataId";
        aVar.xjA.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "totalLen";
        aVar.xjA.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "offset";
        aVar.xjA.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "isUpload";
        aVar.xjA.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "createTime";
        aVar.xjA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "lastModifyTime";
        aVar.xjA.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileFullPath";
        aVar.xjA.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "fullXml";
        aVar.xjA.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgInfoId";
        aVar.xjA.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "netTimes";
        aVar.xjA.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "isUseCdn";
        aVar.xjA.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "signature";
        aVar.xjA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "fakeAeskey";
        aVar.xjA.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "fakeSignature";
        aVar.xjA.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.columns[20] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean aOC() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }
}
