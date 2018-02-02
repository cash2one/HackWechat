package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import java.util.List;
import org.json.JSONArray;

public final class c {
    public String jey = "ok";
    public List<b> jvD = null;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mErrorMsg:");
        stringBuilder.append(this.jey);
        stringBuilder.append(" mWifiList:");
        if (this.jvD == null || this.jvD.size() <= 0) {
            stringBuilder.append("null:");
        } else {
            for (b bVar : this.jvD) {
                stringBuilder.append(" WiFiItem:");
                stringBuilder.append(bVar);
            }
        }
        return stringBuilder.toString();
    }

    public final JSONArray ahH() {
        JSONArray jSONArray = new JSONArray();
        for (b sN : this.jvD) {
            jSONArray.put(sN.sN());
        }
        return jSONArray;
    }
}
