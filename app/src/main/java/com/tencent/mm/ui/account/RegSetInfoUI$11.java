package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class RegSetInfoUI$11 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$11(RegSetInfoUI regSetInfoUI, k kVar) {
        this.xSg = regSetInfoUI;
        this.flZ = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = RegSetInfoUI.a(this.xSg).getText().toString().trim();
        String trim2 = RegSetInfoUI.b(this.xSg).getText().toString().trim();
        if (trim2 == null || trim2.length() <= 0) {
            h.h(this.xSg, R.l.eSF, R.l.eDR);
            return;
        }
        int e = RegSetInfoUI.e(this.xSg);
        ar.CG().a(126, this.xSg);
        k yVar = new y("", RegSetInfoUI.y(this.xSg), trim2, RegSetInfoUI.z(this.xSg), RegSetInfoUI.A(this.xSg), RegSetInfoUI.B(this.xSg), "", "", RegSetInfoUI.g(this.xSg), e, trim, ((y) this.flZ).Op(), RegSetInfoUI.C(this.xSg).coF(), RegSetInfoUI.D(this.xSg), RegSetInfoUI.j(this.xSg));
        yVar.mx(RegSetInfoUI.E(this.xSg));
        yVar.is(RegSetInfoUI.F(this.xSg));
        ar.CG().a(yVar, 0);
        RegSetInfoUI regSetInfoUI = this.xSg;
        Context context = this.xSg;
        this.xSg.getString(R.l.dGO);
        RegSetInfoUI.a(regSetInfoUI, h.a(context, this.xSg.getString(R.l.eEh), true, new 1(this, yVar)));
    }
}
