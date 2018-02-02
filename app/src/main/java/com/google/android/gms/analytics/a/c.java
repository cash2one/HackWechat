package com.google.android.gms.analytics.a;

import com.google.android.gms.c.af;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    Map<String, String> aEN = new HashMap();

    public final Map<String, String> an(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.aEN.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public final String toString() {
        return af.c(this.aEN);
    }
}
