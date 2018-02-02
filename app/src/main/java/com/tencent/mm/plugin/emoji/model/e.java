package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public final Map<String, Integer> lxA = new HashMap();
    private cs lxz = new cs();

    public final void f(String str, int i, int i2, String str2) {
        this.lxz.fqU.fqV = str;
        this.lxz.fqU.status = i;
        this.lxz.fqU.progress = i2;
        this.lxz.fqU.fqW = str2;
        a.xef.m(this.lxz);
        if (i != 6) {
            this.lxA.remove(str);
        } else if (i2 < 0 || i2 >= 100) {
            this.lxA.remove(str);
        } else {
            this.lxA.put(str, Integer.valueOf(i2));
        }
    }
}
