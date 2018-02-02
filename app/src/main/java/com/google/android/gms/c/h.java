package com.google.android.gms.c;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable$Columns;
import java.util.HashMap;
import java.util.Map;

public final class h extends af<h> {
    public String aGm;
    public String aWo;
    public String aWp;
    public String aWq;
    public boolean aWr;
    public String aWs;
    public boolean aWt;
    public double aWu;

    public final /* synthetic */ void a(af afVar) {
        boolean z = true;
        h hVar = (h) afVar;
        if (!TextUtils.isEmpty(this.aWo)) {
            hVar.aWo = this.aWo;
        }
        if (!TextUtils.isEmpty(this.aGm)) {
            hVar.aGm = this.aGm;
        }
        if (!TextUtils.isEmpty(this.aWp)) {
            hVar.aWp = this.aWp;
        }
        if (!TextUtils.isEmpty(this.aWq)) {
            hVar.aWq = this.aWq;
        }
        if (this.aWr) {
            hVar.aWr = true;
        }
        if (!TextUtils.isEmpty(this.aWs)) {
            hVar.aWs = this.aWs;
        }
        if (this.aWt) {
            hVar.aWt = this.aWt;
        }
        if (this.aWu != 0.0d) {
            double d = this.aWu;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            w.e(z, "Sample rate must be between 0% and 100%");
            hVar.aWu = d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.aWo);
        hashMap.put(ClientInfoTable$Columns.CLIENTID, this.aGm);
        hashMap.put("userId", this.aWp);
        hashMap.put("androidAdId", this.aWq);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.aWr));
        hashMap.put("sessionControl", this.aWs);
        hashMap.put("nonInteraction", Boolean.valueOf(this.aWt));
        hashMap.put("sampleRate", Double.valueOf(this.aWu));
        return aj(hashMap);
    }
}
