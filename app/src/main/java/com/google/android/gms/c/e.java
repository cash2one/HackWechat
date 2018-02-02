package com.google.android.gms.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class e extends af<e> {
    public Map<Integer, String> aWm = new HashMap(4);

    public final /* synthetic */ void a(af afVar) {
        ((e) afVar).aWm.putAll(this.aWm);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.aWm.entrySet()) {
            hashMap.put("dimension" + entry.getKey(), entry.getValue());
        }
        return aj(hashMap);
    }
}
