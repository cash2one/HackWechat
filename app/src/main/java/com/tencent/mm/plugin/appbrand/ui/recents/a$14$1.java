package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.ui.recents.a.14;
import java.util.ArrayList;

class a$14$1 implements Runnable {
    final /* synthetic */ ArrayList jPl;
    final /* synthetic */ ArrayList jPn;
    final /* synthetic */ 14 jPs;

    a$14$1(14 14, ArrayList arrayList, ArrayList arrayList2) {
        this.jPs = 14;
        this.jPn = arrayList;
        this.jPl = arrayList2;
    }

    public final void run() {
        a.a(this.jPs.jPj, this.jPn);
        a.a(this.jPs.jPj, this.jPl, true);
    }
}
