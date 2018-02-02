package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aj extends af<aj> {
    public String aEW;
    public String aEX;
    public String aYv;
    public String aYw;

    public final void a(aj ajVar) {
        if (!TextUtils.isEmpty(this.aEW)) {
            ajVar.aEW = this.aEW;
        }
        if (!TextUtils.isEmpty(this.aEX)) {
            ajVar.aEX = this.aEX;
        }
        if (!TextUtils.isEmpty(this.aYv)) {
            ajVar.aYv = this.aYv;
        }
        if (!TextUtils.isEmpty(this.aYw)) {
            ajVar.aYw = this.aYw;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.aEW);
        hashMap.put("appVersion", this.aEX);
        hashMap.put("appId", this.aYv);
        hashMap.put("appInstallerId", this.aYw);
        return aj(hashMap);
    }
}
