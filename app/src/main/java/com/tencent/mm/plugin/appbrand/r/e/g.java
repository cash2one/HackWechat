package com.tencent.mm.plugin.appbrand.r.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> jUk = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public final Iterator<String> amb() {
        return Collections.unmodifiableSet(this.jUk.keySet()).iterator();
    }

    public final String uM(String str) {
        String str2 = (String) this.jUk.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final byte[] amc() {
        return this.content;
    }

    public final void put(String str, String str2) {
        this.jUk.put(str, str2);
    }

    public final boolean uN(String str) {
        return this.jUk.containsKey(str);
    }
}
