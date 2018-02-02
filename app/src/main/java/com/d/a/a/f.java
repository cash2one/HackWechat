package com.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private final WifiManager bgP;
    private final LocationManager bgQ;
    final SensorManager bgR;
    final PackageManager bgS;
    PackageInfo bgT;
    String bgU;
    String bgV;
    String bgW;
    private int bgX = 0;
    private int bgY = 0;
    int bgZ = 0;
    int bha = 0;
    int bhb = 0;
    int bhc = 0;
    private String bhd = "203";
    String imei;
    final Context mContext;
    private String version = "2.0.1";
    String versionName;

    public f(Context context) {
        this.mContext = context;
        this.bgP = (WifiManager) this.mContext.getSystemService("wifi");
        this.bgQ = (LocationManager) this.mContext.getSystemService("location");
        this.bgR = (SensorManager) this.mContext.getSystemService("sensor");
        this.bgS = this.mContext.getPackageManager();
        this.bgT = new PackageInfo();
        try {
            this.bgT = this.bgS.getPackageInfo(this.mContext.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
    }

    public final String p(byte[] bArr) {
        int i;
        int i2 = 1;
        Object hashMap = new HashMap();
        hashMap.put("version", this.version);
        hashMap.put("app_name", bq(this.versionName));
        if (this.bgU != null) {
            hashMap.put("app_label", bq(Base64.encodeToString(this.bgU.getBytes(), 0)));
        } else {
            hashMap.put("app_label", "");
        }
        String str = "chips";
        if (rW()) {
            i = 1;
        } else {
            i = 0;
        }
        this.bgY = i;
        i = (this.bgP == null || !this.bgP.isWifiEnabled()) ? 0 : 1;
        if ((i | rX()) == 0) {
            i2 = 0;
        }
        this.bgX = i2;
        hashMap.put(str, Integer.toBinaryString((((((this.bhc | 0) | (this.bhb << 1)) | (this.bha << 2)) | (this.bgZ << 3)) | (this.bgY << 4)) | (this.bgX << 5)));
        hashMap.put("source", this.bhd);
        hashMap.put("query", new String(bArr));
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("model", bq(Base64.encodeToString(this.bgV.getBytes(), 0)));
            hashMap2.put("version", bq(this.bgW));
            hashMap2.put("imei", bq(this.imei));
            return new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static String bq(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private boolean rW() {
        boolean z = false;
        try {
            z = this.bgQ.isProviderEnabled("gps");
        } catch (Exception e) {
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private boolean rX() {
        boolean z = false;
        if (this.bgP != null) {
            z = this.bgP.isWifiEnabled();
            if (!z) {
                try {
                    if (VERSION.SDK_INT >= 18) {
                        z = this.bgP.isScanAlwaysAvailable();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                }
            }
        }
        return z;
    }
}
