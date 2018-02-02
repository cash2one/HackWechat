package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashMap;
import java.util.Map;

public abstract class b {
    protected final String aBs = "weixin/android";

    public abstract void a(b bVar, c cVar);

    public final void a(b bVar, c cVar, af afVar) {
        e.post(new 1(this, bVar, cVar, afVar), getClass().getName());
    }

    public static Map<String, String> HI(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
