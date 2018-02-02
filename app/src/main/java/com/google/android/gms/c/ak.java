package com.google.android.gms.c;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ak extends af<ak> {
    public String aEO;
    public String aYA;
    public String aYB;
    public String aYC;
    public String aYD;
    public String aYE;
    public String aYx;
    public String aYy;
    public String aYz;
    public String mName;

    public final /* synthetic */ void a(af afVar) {
        ak akVar = (ak) afVar;
        if (!TextUtils.isEmpty(this.mName)) {
            akVar.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.aYx)) {
            akVar.aYx = this.aYx;
        }
        if (!TextUtils.isEmpty(this.aYy)) {
            akVar.aYy = this.aYy;
        }
        if (!TextUtils.isEmpty(this.aYz)) {
            akVar.aYz = this.aYz;
        }
        if (!TextUtils.isEmpty(this.aYA)) {
            akVar.aYA = this.aYA;
        }
        if (!TextUtils.isEmpty(this.aEO)) {
            akVar.aEO = this.aEO;
        }
        if (!TextUtils.isEmpty(this.aYB)) {
            akVar.aYB = this.aYB;
        }
        if (!TextUtils.isEmpty(this.aYC)) {
            akVar.aYC = this.aYC;
        }
        if (!TextUtils.isEmpty(this.aYD)) {
            akVar.aYD = this.aYD;
        }
        if (!TextUtils.isEmpty(this.aYE)) {
            akVar.aYE = this.aYE;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.aYx);
        hashMap.put("medium", this.aYy);
        hashMap.put("keyword", this.aYz);
        hashMap.put("content", this.aYA);
        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, this.aEO);
        hashMap.put("adNetworkId", this.aYB);
        hashMap.put("gclid", this.aYC);
        hashMap.put("dclid", this.aYD);
        hashMap.put("aclid", this.aYE);
        return aj(hashMap);
    }
}
