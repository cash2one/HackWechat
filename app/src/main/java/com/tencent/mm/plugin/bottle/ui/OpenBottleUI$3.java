package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ba.a;

class OpenBottleUI$3 implements a {
    final /* synthetic */ OpenBottleUI kDa;
    final /* synthetic */ r kDb;

    OpenBottleUI$3(OpenBottleUI openBottleUI, r rVar) {
        this.kDa = openBottleUI;
        this.kDb = rVar;
    }

    public final boolean HB() {
        return OpenBottleUI.d(this.kDa);
    }

    public final void HA() {
        if (this.kDb != null) {
            this.kDb.dismiss();
        }
    }
}
