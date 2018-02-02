package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class b {
    private static long tkU = 2592000;
    private static b tkV;
    private c tkW;
    private Map<String, Long> tkX = new HashMap();
    private long tkY = 0;

    static /* synthetic */ long NW(String str) {
        long j = bh.getLong(str, 604800);
        return j > tkU ? tkU : j;
    }

    static /* synthetic */ void b(b bVar) {
        c bPb = bVar.bPb();
        String format = String.format("delete from %s where %s<%s", new Object[]{"WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)});
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + bPb.fx("WebViewData", format));
    }

    public static b bPa() {
        if (tkV == null) {
            tkV = new b();
        }
        return tkV;
    }

    public final c bPb() {
        if (this.tkW == null) {
            g.Dk();
            this.tkW = new c(g.Dj().gQj);
        }
        return this.tkW;
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, boolean z) {
        long j;
        long j2;
        Cursor rawQuery = bPb().rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.eI(str, str2)}), new String[0]);
        if (rawQuery == null) {
            j = 0;
        } else {
            j2 = 0;
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
            j = j2;
        }
        long length = ((long) (str2.getBytes().length + str3.getBytes().length)) - j;
        if (this.tkX.containsKey(str)) {
            j2 = ((Long) this.tkX.get(str)).longValue();
        } else {
            c bPb = bPb();
            String format = String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.aa(str, "###@@@@TOTAL@@@###SIZE####", "_")});
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + format);
            j2 = 0;
            rawQuery = bPb.rawQuery(format, new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    j2 = rawQuery.getLong(0);
                }
                rawQuery.close();
            }
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + j2);
        }
        long j3 = j2 + length;
        long j4 = str.equals("wx62d9035fd4fd2059") ? j3 - 52428800 : j3 - 10485760;
        x.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[]{Long.valueOf(j), Long.valueOf(r10), Long.valueOf(length), Long.valueOf(j3), Long.valueOf(j4)});
        if (j4 > 0 && !z) {
            return false;
        }
        ar.Dm().F(new 1(this, j4, str, j3, str2, str3, str4, str5));
        return true;
    }

    public final a eH(String str, String str2) {
        c bPb = bPb();
        String format = String.format("select * from %s where %s=\"%s\"", new Object[]{"WebViewData", "appIdKey", c.eI(str, str2)});
        x.d("MicroMsg.WebViewDataStorage", "getData: " + format);
        Cursor rawQuery = bPb.rawQuery(format, new String[0]);
        a aVar = new a();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }

    public final void b(String str, JSONArray jSONArray) {
        c bPb = bPb();
        if (jSONArray != null && jSONArray.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    stringBuilder.append("\"" + c.eI(str, jSONArray.getString(i)) + "\",");
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewDataStorage", "clearData: " + e.getMessage());
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            String format = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
            x.d("MicroMsg.WebViewDataStorage", "deleteData: " + format);
            x.d("MicroMsg.WebViewDataStorage", "clearData: " + bPb.fx("WebViewData", format));
        }
    }

    public final void NV(String str) {
        c bPb = bPb();
        String format = String.format("delete from %s where %s=\"%s\"", new Object[]{"WebViewData", "appId", str});
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + bPb.fx("WebViewData", format));
    }
}
