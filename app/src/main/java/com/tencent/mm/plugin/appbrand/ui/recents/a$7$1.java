package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.ui.recents.a.7;
import java.util.ArrayList;

class a$7$1 implements Runnable {
    final /* synthetic */ ArrayList jPl;
    final /* synthetic */ ArrayList jPn;
    final /* synthetic */ 7 jPo;

    a$7$1(7 7, ArrayList arrayList, ArrayList arrayList2) {
        this.jPo = 7;
        this.jPn = arrayList;
        this.jPl = arrayList2;
    }

    public final void run() {
        a.a(this.jPo.jPj, this.jPn);
        a.a(this.jPo.jPj, this.jPl, false);
    }
}
