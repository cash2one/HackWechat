package com.tencent.mm.ui.voicesearch;

import java.util.ArrayList;
import java.util.List;

class b$5 implements Runnable {
    final /* synthetic */ List juo;
    final /* synthetic */ b zqE;

    b$5(b bVar, List list) {
        this.zqE = bVar;
        this.juo = list;
    }

    public final void run() {
        if (b.a(this.zqE) == null) {
            b.a(this.zqE, new ArrayList());
        }
        b.a(this.zqE).clear();
        b.a(this.zqE).addAll(this.juo);
        b.a(this.zqE).add("officialaccounts");
        b.a(this.zqE).add("helper_entry");
    }
}
