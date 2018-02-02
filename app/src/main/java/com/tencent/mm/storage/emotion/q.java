package com.tencent.mm.storage.emotion;

import com.tencent.mm.g.b.dc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class q extends dc {
    protected static a gJc;

    protected final a Ac() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xjA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "key";
        aVar.columns[1] = "cnValue";
        aVar.xjA.put("cnValue", "TEXT");
        stringBuilder.append(" cnValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "qqValue";
        aVar.xjA.put("qqValue", "TEXT");
        stringBuilder.append(" qqValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "twValue";
        aVar.xjA.put("twValue", "TEXT");
        stringBuilder.append(" twValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "enValue";
        aVar.xjA.put("enValue", "TEXT");
        stringBuilder.append(" enValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "thValue";
        aVar.xjA.put("thValue", "TEXT");
        stringBuilder.append(" thValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.FILENAME;
        aVar.xjA.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "eggIndex";
        aVar.xjA.put("eggIndex", "INTEGER default '-1' ");
        stringBuilder.append(" eggIndex INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "position";
        aVar.xjA.put("position", "INTEGER default '-1' ");
        stringBuilder.append(" position INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "flag";
        aVar.xjA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        aVar.columns[10] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public q(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_position = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key:").append(this.field_key).append("/n");
        stringBuilder.append("cn:").append(this.field_cnValue).append("/n");
        stringBuilder.append("qq:").append(this.field_qqValue).append("/n");
        stringBuilder.append("en:").append(this.field_enValue).append("/n");
        stringBuilder.append("th:").append(this.field_thValue).append("/n");
        stringBuilder.append("tw:").append(this.field_twValue).append("/n");
        stringBuilder.append("position:").append(this.field_position).append("/n");
        stringBuilder.append("file Name:").append(this.field_fileName).append("/n");
        stringBuilder.append("egg index:").append(this.field_eggIndex).append("/n");
        return stringBuilder.toString();
    }
}
