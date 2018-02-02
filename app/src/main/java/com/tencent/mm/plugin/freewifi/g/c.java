package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.bg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bg {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ssidmd5";
        aVar.xjA.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "ssidmd5";
        aVar.columns[1] = "ssid";
        aVar.xjA.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mid";
        aVar.xjA.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xjA.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connectState";
        aVar.xjA.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expiredTime";
        aVar.xjA.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiType";
        aVar.xjA.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "action";
        aVar.xjA.put("action", "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showUrl";
        aVar.xjA.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "showWordEn";
        aVar.xjA.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "showWordCn";
        aVar.xjA.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "showWordTw";
        aVar.xjA.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "mac";
        aVar.xjA.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "verifyResult";
        aVar.xjA.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        aVar.columns[14] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
