package com.tencent.mapsdk.rastercore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mapsdk.rastercore.d.e;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class a {
    public static StringBuffer a = new StringBuffer(300);
    private static final String b = a.class.getSimpleName();
    private static boolean c = false;
    private static WeakReference<e> d = null;

    @SuppressLint({"NewApi"})
    public static String a() {
        Object obj = "";
        Context a = e.a();
        if (VERSION.SDK_INT < 23 || (a != null && a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            obj = ((TelephonyManager) a.getSystemService("phone")).getDeviceId();
        }
        return TextUtils.isEmpty(obj) ? "noIMEI" : obj;
    }

    public static void a(e eVar) {
        d = new WeakReference(eVar);
        if (!c) {
            new 1().start();
        }
    }

    static /* synthetic */ void a(String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getJSONObject("info").getInt("error") != -1) {
                if (jSONObject.getJSONObject("detail").getJSONObject("cfg").optJSONObject("raster_base_map_world") != null) {
                    z = true;
                }
                if (e.r() != z) {
                    e.e(z);
                    e.d(z);
                    if (d.get() != null) {
                        ((e) d.get()).d().post(new Runnable() {
                            public final void run() {
                                ((e) a.d.get()).a(false, false);
                            }
                        });
                    }
                }
            } else if (jSONObject.getJSONObject("info").getString("msg").equals("KEY_NOT_EXISTS")) {
                e.c(false);
            }
        } catch (Exception e) {
            new StringBuilder("checkJsonResult gets error:").append(e.getMessage());
        }
    }

    static /* synthetic */ String b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) e.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "";
    }
}
