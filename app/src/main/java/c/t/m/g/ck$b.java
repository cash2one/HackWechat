package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;
import org.json.JSONObject;

class ck$b implements Runnable {
    private final JSONObject a;
    private cl b;
    private cm c;
    private /* synthetic */ ck d;

    public ck$b(ck ckVar) {
        this.d = ckVar;
        this.a = new JSONObject();
        this.b = null;
        this.c = null;
        this.b = cl.a();
        this.c = cm.a();
    }

    public final void run() {
        boolean b;
        try {
            if (Math.abs(System.currentTimeMillis() - this.b.c("last_pull_time")) >= ck.e()) {
                b = ck.b(this.d);
                if (b) {
                    this.c.c();
                }
                Thread.currentThread().setPriority(1);
                JSONObject a = a();
                if (a != this.a) {
                    int parseInt = Integer.parseInt(a.optString(DownloadInfo.STATUS, "-5"));
                    ch.a("CC_Run", "status:" + parseInt);
                    switch (parseInt) {
                        case 0:
                            if (a.has("version")) {
                                a(a);
                                break;
                            }
                            break;
                    }
                    String str = "last_pull_time";
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    SharedPreferences b2 = this.c.b();
                    if (b2 != null) {
                        Editor edit = b2.edit();
                        edit.putString(str, valueOf);
                        edit.apply();
                    }
                    Thread.sleep(2000);
                    ch.a("CC_Run", "---> finish update xml");
                }
                this.b.b();
                if (b) {
                    this.c.d();
                }
            } else {
                ch.a("CC_Run", "skip pull");
            }
        } catch (Throwable th) {
            ch.a("CC_Run", th.getMessage(), th);
            return;
        }
        if (ck.b(this.d)) {
            ck.c(this.d);
        } else {
            ck.d(this.d);
        }
    }

    private void a(JSONObject jSONObject) {
        SharedPreferences b = this.c.b();
        if (b != null) {
            int parseInt;
            int b2 = this.b.b("cc_version");
            try {
                parseInt = Integer.parseInt(jSONObject.optString("version", this.b.e("cc_version")));
            } catch (Throwable th) {
                parseInt = b2;
            }
            if (parseInt == b2) {
                ch.a("CC_Run", "local version == server version");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
            JSONObject jSONObject2 = optJSONObject == null ? this.a : optJSONObject;
            Editor edit = b.edit();
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    String e = this.b.e(str);
                    if (!(e == null || e.length() == 0)) {
                        edit.putString(str, jSONObject2.optString(str, e));
                    }
                } catch (Exception e2) {
                    ch.b("CC_Run", e2.getMessage());
                }
            }
            edit.putString("cc_version", String.valueOf(parseInt));
            try {
                long parseLong = Long.parseLong(jSONObject2.optString("cc_req_interval", this.b.e("cc_req_interval")));
                if (parseLong < 3600000) {
                    parseLong = 3600000;
                } else if (parseLong > 86400000) {
                    parseLong = 86400000;
                }
                edit.putString("cc_req_interval", String.valueOf(parseLong));
            } catch (Throwable th2) {
            }
            edit.apply();
        }
    }

    private JSONObject a() {
        if (ck.e(this.d) == null) {
            return this.a;
        }
        String str = "https://cc.map.qq.com/?get_c3";
        ch.a("CC_Run", "cc_url:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc_version", this.b.e("cc_version"));
            jSONObject.put("m_module", cl.a);
            jSONObject.put("m_channel", cl.b);
            jSONObject.put("m_version", cl.c);
            jSONObject.put("imei", b());
            String a = ci.a(jSONObject.toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
            ch.a("CC_Run", "req:" + a);
            a = ck.e(this.d).a(str, a.getBytes());
            if (TextUtils.isEmpty(a)) {
                ch.a("CC_Run", "net work error! res = " + a);
                return this.a;
            }
            Object obj;
            ch.a("CC_Run", "res:" + a);
            str = this.a.toString();
            if (str.equals(a)) {
                ch.a("CC_Run", "network or server error,response empty json");
                obj = str;
            } else {
                ch.a("CC_Run", "start dec");
                str = ci.b(a, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                ch.a("CC_Run", "end dec");
                a = str;
            }
            if (TextUtils.isEmpty(obj)) {
                return this.a;
            }
            return new JSONObject(obj);
        } catch (Throwable th) {
            ch.a("CC_Run", th.getMessage(), th);
            return this.a;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static String b() {
        String deviceId;
        String str = "";
        try {
            deviceId = ((TelephonyManager) ck.f().getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            deviceId = str;
        }
        return TextUtils.isEmpty(deviceId) ? "" : deviceId;
    }
}
