package com.google.android.gms.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends af<f> {
    public Map<Integer, Double> aWn = new HashMap(4);

    public final /* synthetic */ void a(af afVar) {
        ((f) afVar).aWn.putAll(this.aWn);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.aWn.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return aj(hashMap);
    }
}
