package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ba.a;

class j$7 implements a {
    final /* synthetic */ r kDb;

    j$7(r rVar) {
        this.kDb = rVar;
    }

    public final boolean HB() {
        return j.access$200();
    }

    public final void HA() {
        if (this.kDb != null) {
            this.kDb.dismiss();
        }
    }
}
