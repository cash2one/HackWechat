package com.tencent.mm.ui.account.mobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.z.ar;

class e$11 implements OnClickListener {
    final /* synthetic */ e xTT;

    e$11(e eVar) {
        this.xTT = eVar;
    }

    public final void onClick(View view) {
        this.xTT.xTM.nZZ[1] = 2;
        this.xTT.xTM.hgg = 7;
        this.xTT.xTM.xTZ.reset();
        ar.CG().b(c.CTRL_INDEX, this.xTT);
        e.a(this.xTT);
    }
}
