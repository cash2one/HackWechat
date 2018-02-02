package com.tencent.mm.plugin.product.b;

import java.util.Comparator;
import java.util.Map.Entry;

class c$1 implements Comparator<Entry<String, String>> {
    c$1() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
    }
}
