package com.tencent.mm.ui;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class HomeUI$4 extends c<ck> {
    final /* synthetic */ HomeUI xGv;

    HomeUI$4(HomeUI homeUI) {
        this.xGv = homeUI;
        this.xen = ck.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (HomeUI.l(this.xGv) != null) {
            HomeUI.l(this.xGv).post(new 1(this));
        }
        HomeUI.n(this.xGv).cnm();
        return false;
    }
}
