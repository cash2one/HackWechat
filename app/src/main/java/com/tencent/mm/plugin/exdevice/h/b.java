package com.tencent.mm.plugin.exdevice.h;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bq {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceID";
        aVar.xjA.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "deviceID";
        aVar.columns[1] = "brandName";
        aVar.xjA.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mac";
        aVar.xjA.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "deviceType";
        aVar.xjA.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connProto";
        aVar.xjA.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "connStrategy";
        aVar.xjA.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "closeStrategy";
        aVar.xjA.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "md5Str";
        aVar.xjA.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "authKey";
        aVar.xjA.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xjA.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "sessionKey";
        aVar.xjA.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "sessionBuf";
        aVar.xjA.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "authBuf";
        aVar.xjA.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuffer";
        aVar.xjA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.columns[14] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
