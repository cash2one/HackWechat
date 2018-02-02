package c.t.m.g;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bs extends bk {
    private static boolean a = false;

    public final void a(bg bgVar) {
        bj bjVar = new bj();
        bi biVar = new bi();
        bh bhVar = new bh();
        try {
            Integer valueOf;
            if (cg.a(biVar.b) || !a) {
                valueOf = Integer.valueOf(1);
                bgVar.a.put("needUpdateState", valueOf);
                a = true;
            } else {
                valueOf = Integer.valueOf(0);
                bgVar.a.put("needUpdateState", valueOf);
            }
            if (cg.a(biVar.b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", bjVar.a);
                jSONObject.put("osVersion", bjVar.b);
                jSONObject.put("imei", bjVar.c);
                jSONObject.put("imsi", bjVar.d);
                jSONObject.put("pseudoId", bjVar.e);
                bgVar.a.put("RegistDeviceInfo", jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", biVar.a);
            jSONObject2.put("deviceId", biVar.b);
            jSONObject2.put("sdkVersion", biVar.c);
            bgVar.a.put("BindDeviceInfo", jSONObject2);
            jSONObject2 = new JSONObject();
            jSONObject2.put("bundle", bhVar.a);
            jSONObject2.put("verCode", bhVar.b);
            jSONObject2.put("verName", bhVar.c);
            jSONObject2.put("appId", bhVar.e);
            jSONObject2.put("uuid", bhVar.d);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            bgVar.a.put("AppState", jSONArray);
            int g = p.g();
            bgVar.a.put(DownloadInfo.NETTYPE, cb.a(g));
            String a = be.a(p.j().intValue());
            bgVar.a.put("oper", a);
        } catch (Exception e) {
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            String a;
            Object optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        cb.a("");
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            String optString2 = jSONObject.optString("deviceId");
            if (TextUtils.isEmpty(optString2)) {
                cb.a("");
            } else {
                a = cb.a();
                if (!(TextUtils.isEmpty(optString2) || optString2.equals(a))) {
                    cb.a(optString2);
                }
            }
            a = jSONObject.optString("oper");
            if (!TextUtils.isEmpty(a)) {
                be a2 = be.a();
                String b = p.b();
                if (!cg.a(b) && !"unknown".equals(b) && !cg.a(a) && !"unknown".equals(a)) {
                    synchronized (a2.a) {
                        if (!a.equals((String) a2.a.get(b))) {
                            a2.a.put(b, a);
                            cb.a("HalleyOperInfo_" + m.b(), a2.b());
                        }
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    public final String c() {
        return "state";
    }
}
