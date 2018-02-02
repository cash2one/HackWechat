package com.tencent.mm.ui.account.mobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.z.ar;

class e$12 implements OnClickListener {
    final /* synthetic */ e xTT;

    e$12(e eVar) {
        this.xTT = eVar;
    }

    public final void onClick(View view) {
        this.xTT.xTM.nZZ[1] = 1;
        this.xTT.xTM.hgg = 6;
        ar.CG().a((int) c.CTRL_INDEX, this.xTT);
        e.a(this.xTT);
    }
}
