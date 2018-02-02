package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ak.a;

class u$1 implements a {
    final /* synthetic */ u yej;

    u$1(u uVar) {
        this.yej = uVar;
    }

    public final boolean uF() {
        if (u.a(this.yej) == -1) {
            this.yej.show();
            return true;
        }
        u.b(this.yej);
        if (u.c(this.yej) >= 0) {
            this.yej.show();
            return true;
        }
        this.yej.cancel();
        return false;
    }
}
