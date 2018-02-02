package com.tencent.mm.plugin.multitalk.a;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.e.14;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ac;

class e$14$1 implements a {
    final /* synthetic */ 14 oGD;

    e$14$1(14 14) {
        this.oGD = 14;
    }

    public final boolean aTc() {
        if (this.oGD.oGz.bcu() || this.oGD.oGz.bcv()) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (this.oGD.oGz.bcv()) {
            int i = this.oGD.oGz.oGk;
            hVar.ME(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
            return;
        }
        hVar.ME(ac.getContext().getString(R.l.ewL));
    }
}
