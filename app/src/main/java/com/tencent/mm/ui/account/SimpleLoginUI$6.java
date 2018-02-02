package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SimpleLoginUI$6 implements OnClickListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$6(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(this.xSL).xPq + " img len" + SimpleLoginUI.g(this.xSL).xPs.length + " " + g.zh());
        k vVar = new v(SimpleLoginUI.g(this.xSL).hNv, SimpleLoginUI.g(this.xSL).xPo, SimpleLoginUI.g(this.xSL).xPt, SimpleLoginUI.h(this.xSL).coF(), SimpleLoginUI.h(this.xSL).xPq, SimpleLoginUI.h(this.xSL).xPr, 0, "", false, false);
        ar.CG().a(vVar, 0);
        SimpleLoginUI simpleLoginUI = this.xSL;
        Context context = this.xSL;
        this.xSL.getString(R.l.dGO);
        SimpleLoginUI.a(simpleLoginUI, h.a(context, this.xSL.getString(R.l.etF), true, new 1(this, vVar)));
    }
}
