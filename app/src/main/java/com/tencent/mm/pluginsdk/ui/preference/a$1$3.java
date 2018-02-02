package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.pluginsdk.ui.preference.a.1;
import com.tencent.mm.ui.MMActivity;

class a$1$3 implements Runnable {
    final /* synthetic */ 1 vta;

    a$1$3(1 1) {
        this.vta = 1;
    }

    public final void run() {
        if (a.a(this.vta.vsY) instanceof MMActivity) {
            ((MMActivity) a.a(this.vta.vsY)).showVKB();
        }
    }
}
