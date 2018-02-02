package com.google.android.gms.c;

import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am extends af<am> {
    public final List<a> aYL = new ArrayList();
    public final List<c> aYM = new ArrayList();
    public final Map<String, List<a>> aYN = new HashMap();
    public b aYO;

    public final /* synthetic */ void a(af afVar) {
        am amVar = (am) afVar;
        amVar.aYL.addAll(this.aYL);
        amVar.aYM.addAll(this.aYM);
        for (Entry entry : this.aYN.entrySet()) {
            String str = (String) entry.getKey();
            for (a aVar : (List) entry.getValue()) {
                if (aVar != null) {
                    Object obj;
                    if (str == null) {
                        obj = "";
                    } else {
                        String str2 = str;
                    }
                    if (!amVar.aYN.containsKey(obj)) {
                        amVar.aYN.put(obj, new ArrayList());
                    }
                    ((List) amVar.aYN.get(obj)).add(aVar);
                }
            }
        }
        if (this.aYO != null) {
            amVar.aYO = this.aYO;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.aYL.isEmpty()) {
            hashMap.put("products", this.aYL);
        }
        if (!this.aYM.isEmpty()) {
            hashMap.put("promotions", this.aYM);
        }
        if (!this.aYN.isEmpty()) {
            hashMap.put("impressions", this.aYN);
        }
        hashMap.put("productAction", this.aYO);
        return aj(hashMap);
    }
}
