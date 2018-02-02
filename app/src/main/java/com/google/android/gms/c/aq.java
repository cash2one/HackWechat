package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import java.util.HashMap;
import java.util.Map;

public final class aq extends af<aq> {
    public String aOB;
    public String aZb;
    public String aZc;

    public final /* synthetic */ void a(af afVar) {
        aq aqVar = (aq) afVar;
        if (!TextUtils.isEmpty(this.aZb)) {
            aqVar.aZb = this.aZb;
        }
        if (!TextUtils.isEmpty(this.aOB)) {
            aqVar.aOB = this.aOB;
        }
        if (!TextUtils.isEmpty(this.aZc)) {
            aqVar.aZc = this.aZc;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(TencentLocation.NETWORK_PROVIDER, this.aZb);
        hashMap.put("action", this.aOB);
        hashMap.put("target", this.aZc);
        return aj(hashMap);
    }
}
