package com.tencent.mm.z;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class u {
    private static volatile u hft;
    private Map<String, c> hfu = new a((byte) 0);

    public static u GK() {
        if (hft == null) {
            synchronized (u.class) {
                if (hft == null) {
                    hft = new u();
                }
            }
        }
        return hft;
    }

    private u() {
    }

    public final b hx(String str) {
        c cVar = (c) this.hfu.get(str);
        if (cVar != null) {
            return cVar.hfw;
        }
        return null;
    }

    public final b t(String str, boolean z) {
        c cVar = (c) this.hfu.get(str);
        if (cVar == null) {
            if (!z) {
                return null;
            }
            cVar = new c();
            this.hfu.put(str, cVar);
        }
        return cVar.hfw;
    }

    public final b hy(String str) {
        c cVar = (c) this.hfu.remove(str);
        if (cVar != null) {
            return cVar.hfw;
        }
        return null;
    }

    public static String hz(String str) {
        return "SessionId@" + str + "#" + System.nanoTime();
    }

    public String toString() {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCenter \nDataStore size : ").append(this.hfu.size());
        Set<Entry> linkedHashSet = new LinkedHashSet(this.hfu.entrySet());
        for (Entry entry : linkedHashSet) {
            if (entry != null) {
                c cVar = (c) entry.getValue();
                if (cVar != null) {
                    stringBuilder.append("\nDataStore id : ").append((String) entry.getKey());
                    stringBuilder.append(", CT : ").append(cVar.hfx).append("ms");
                    stringBuilder.append(", TTL : ").append((currentTimeMillis - cVar.hfx) / 1000).append("s");
                }
            }
        }
        linkedHashSet.clear();
        return stringBuilder.toString();
    }
}
