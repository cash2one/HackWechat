package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.b.dp;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class g extends dp {
    protected static a gJc;
    int fDt = -1;

    static {
        a aVar = new a();
        aVar.hSY = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = FFmpegMetadataRetriever.METADATA_KEY_FILENAME;
        aVar.xjA.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "user";
        aVar.xjA.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgid";
        aVar.xjA.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "offset";
        aVar.xjA.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "filenowsize";
        aVar.xjA.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "totallen";
        aVar.xjA.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createtime";
        aVar.xjA.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastmodifytime";
        aVar.xjA.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "clientid";
        aVar.xjA.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "voicelenght";
        aVar.xjA.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "msglocalid";
        aVar.xjA.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "human";
        aVar.xjA.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "voiceformat";
        aVar.xjA.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "nettimes";
        aVar.xjA.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved1";
        aVar.xjA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "reserved2";
        aVar.xjA.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        aVar.columns[17] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean UH() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }
}
