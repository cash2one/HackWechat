package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.z.ba.a;

class e$3 implements a {
    final /* synthetic */ e pje;

    e$3(e eVar) {
        this.pje = eVar;
    }

    public final boolean HB() {
        return this.pje.isDeleteCancel;
    }

    public final void HA() {
        if (this.pje.tipDialog != null) {
            this.pje.tipDialog.dismiss();
            this.pje.tipDialog = null;
        }
    }
}
