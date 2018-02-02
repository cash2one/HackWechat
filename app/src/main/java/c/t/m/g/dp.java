package c.t.m.g;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class dp {
    public static int a = 0;
    public final dr b;
    public final do c;
    private final dn d;
    private final List<dm> e;

    public dp(dr drVar, dn dnVar, do doVar, List<dm> list) {
        this.b = drVar;
        this.d = dnVar;
        this.c = doVar;
        this.e = list;
    }

    public final boolean a() {
        return this.c != null;
    }

    private String b(int i, String str, cr crVar, boolean z, boolean z2, boolean z3) {
        if (crVar == null) {
            return null;
        }
        try {
            boolean z4;
            String str2;
            String str3;
            int abs;
            StringBuilder stringBuilder;
            if (this.d == null) {
                z4 = true;
            } else {
                boolean z5 = a != this.d.e;
                a = this.d.e;
                z4 = z5;
            }
            String a = eg.a(this.b);
            String a2 = eg.a(this.d, z4);
            String a3 = eg.a(this.c);
            String a4 = dm.a(this.e);
            if (z2) {
                str2 = "{}";
            } else {
                str2 = a3;
            }
            cs csVar = crVar.b;
            Map hashMap = new HashMap();
            hashMap.put("imei", csVar.a());
            hashMap.put("imsi", csVar.b());
            hashMap.put("phonenum", j.b(csVar.d));
            hashMap.put("qq", j.b(csVar.f));
            hashMap.put("mac", csVar.c().toLowerCase(Locale.ENGLISH));
            String jSONObject = new JSONObject(hashMap).toString();
            String f = csVar.f();
            ee.a();
            int a5 = ee.a(crVar.a);
            String c = eh.c(crVar);
            try {
                if (a.equals("[]") && !c.equals("{}")) {
                    JSONObject jSONObject2 = new JSONObject(c);
                    jSONObject2.remove("ssid");
                    a = "[" + jSONObject2.toString() + "]";
                }
                str3 = a;
            } catch (Throwable th) {
                th.toString();
                str3 = a;
            }
            a = csVar.i;
            if (a != null) {
                a = a.replace("\"", "");
            }
            if (a != null) {
                a = a.replace("|", "");
            }
            String str4 = a + "_" + csVar.h;
            if (z3) {
                a3 = csVar.a();
                if (a3 != null) {
                    abs = (Math.abs(a3.hashCode()) % 1000) + 1001;
                    stringBuilder = new StringBuilder("{\"version\":\"");
                    if (csVar.q != null) {
                        a = "None";
                    } else {
                        a = csVar.q;
                    }
                    a = (stringBuilder.append(a).append("\",\"address\":").append(i).toString() + ",\"source\":" + abs + ",\"access_token\":\"" + f + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1") + ",\"control\":0";
                    if (z) {
                        a = a + ",\"detectgps\":0";
                    } else {
                        a = a + ",\"detectgps\":1";
                    }
                    return ((a + ",\"pstat\":" + a5) + ",\"wlan\":" + c) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + str3 + ",\"bles\":" + a4 + "}";
                }
            }
            abs = 203;
            stringBuilder = new StringBuilder("{\"version\":\"");
            if (csVar.q != null) {
                a = csVar.q;
            } else {
                a = "None";
            }
            a = (stringBuilder.append(a).append("\",\"address\":").append(i).toString() + ",\"source\":" + abs + ",\"access_token\":\"" + f + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1") + ",\"control\":0";
            if (z) {
                a = a + ",\"detectgps\":0";
            } else {
                a = a + ",\"detectgps\":1";
            }
            return ((a + ",\"pstat\":" + a5) + ",\"wlan\":" + c) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + str3 + ",\"bles\":" + a4 + "}";
        } catch (Exception e) {
            return null;
        }
    }

    public final String a(int i, String str, cr crVar, boolean z, boolean z2, boolean z3) {
        return b(i, str, crVar, z, z2, z3);
    }
}
