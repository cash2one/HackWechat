package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.b.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g {
    Set<String> lxH;
    c<fp> lxI;
    private a lxJ;

    public g() {
        this.lxI = new 1(this);
        this.lxJ = new 2(this);
        this.lxH = Collections.synchronizedSet(new HashSet());
        i.aBy().lxw = this.lxJ;
        this.lxI.ceO();
    }
}
