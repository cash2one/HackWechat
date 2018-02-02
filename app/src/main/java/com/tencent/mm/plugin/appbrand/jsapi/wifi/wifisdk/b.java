package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import org.json.JSONObject;

public final class b {
    public boolean jvA = false;
    public boolean jvB = false;
    public boolean jvC = false;
    public String jvx = "";
    public String jvy = "";
    public int jvz;

    public final String toString() {
        return "WiFiItem{mSsid='" + this.jvx + '\'' + ", mBssid='" + this.jvy + '\'' + ", mSignalStrength=" + this.jvz + ", mSecurity=" + this.jvA + '}';
    }

    public final JSONObject sN() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.jvx);
        jSONObject.put("BSSID", this.jvy);
        jSONObject.put("secure", this.jvA);
        jSONObject.put("signalStrength", this.jvz);
        return jSONObject;
    }
}
