package com.tencent.mm.ar;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> hEt = null;
    private static String hEu = null;

    public static boolean PP() {
        return !w.eL(ac.getContext()).equals("zh_CN");
    }

    public static boolean PQ() {
        return bh.PT();
    }

    public static boolean PR() {
        if (q.FR() == 0 && bh.PT()) {
            return false;
        }
        return true;
    }

    public static boolean PS() {
        if (!w.cfi().equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() == TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        return true;
    }

    public static boolean PT() {
        return bh.PT();
    }

    public static a h(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(hEu)) {
                hEt = null;
            }
        } catch (Exception e) {
        }
        if (hEt == null) {
            hEt = new HashMap();
            hEu = str3;
            InputStream inputStream = null;
            String str4 = "";
            try {
                inputStream = context.getAssets().open("country_code.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str3 = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bh.i(e2));
                    }
                }
            } catch (Throwable e3) {
                x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bh.i(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str3 = str4;
                    } catch (Throwable e32) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bh.i(e32));
                        str3 = str4;
                    }
                } else {
                    str3 = str4;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bh.i(e22));
                    }
                }
            }
            String[] split = str3.trim().split("\n");
            String[] split2 = bh.ou(str2).trim().split(",");
            for (String str42 : split) {
                String[] split3 = str42.trim().split(" ");
                if (split3.length < 2) {
                    x.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split[r0]);
                } else {
                    a aVar = new a();
                    aVar.hEv = split3[0];
                    aVar.hEw = split3[1];
                    for (String trim : split2) {
                        String[] split4 = trim.trim().split(":");
                        if (split4.length < 2) {
                            x.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", trim);
                        } else {
                            if (split3[1].equals(split4[0])) {
                                aVar.hEx = split4[1];
                                break;
                            }
                        }
                    }
                    hEt.put(aVar.hEv, aVar);
                }
            }
        }
        return (a) hEt.get(str.toUpperCase());
    }

    public static boolean lG(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            return false;
        }
        return true;
    }

    public static String lH(String str) {
        if (str.startsWith("+886") || str.startsWith("+86")) {
            return "zh-TW";
        }
        if (str.startsWith("+852") || str.startsWith("+853")) {
            return "zh-HK";
        }
        if (str.startsWith("+81")) {
            return "ja";
        }
        if (str.startsWith("+82")) {
            return "ko";
        }
        if (str.startsWith("+66")) {
            return "th";
        }
        if (str.startsWith("+84")) {
            return "vi";
        }
        if (str.startsWith("+62")) {
            return SlookAirButtonFrequentContactAdapter.ID;
        }
        if (str.startsWith("+55")) {
            return "pt";
        }
        if (str.startsWith("+34")) {
            return "es-419";
        }
        return "en";
    }
}
