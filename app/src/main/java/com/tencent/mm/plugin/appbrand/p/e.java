package com.tencent.mm.plugin.appbrand.p;

import java.util.List;

public final class e {
    public static <L extends List<T>, T> L e(L l, List<T> list) {
        if (list != null) {
            l.addAll(list);
        }
        return l;
    }
}
