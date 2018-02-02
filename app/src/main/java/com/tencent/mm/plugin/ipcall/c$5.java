package com.tencent.mm.plugin.ipcall;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ac;

class c$5 implements a {
    final /* synthetic */ c nCj;

    c$5(c cVar) {
        this.nCj = cVar;
    }

    public final boolean aTc() {
        if (i.aTB().aTr()) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (i.aTB().aTu()) {
            int aTa = this.nCj.aTa();
            hVar.MF(String.format("%02d:%02d", new Object[]{Integer.valueOf(aTa / 60), Integer.valueOf(aTa % 60)}));
            return;
        }
        hVar.ME(ac.getContext().getString(R.l.ewL));
    }
}
