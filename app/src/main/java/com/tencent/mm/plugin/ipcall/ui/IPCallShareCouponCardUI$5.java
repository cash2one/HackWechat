package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.ui.applet.o.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class IPCallShareCouponCardUI$5 implements b {
    final /* synthetic */ String iGf;
    final /* synthetic */ IPCallShareCouponCardUI nMs;
    final /* synthetic */ EditText nMt;
    final /* synthetic */ int nMu;

    IPCallShareCouponCardUI$5(IPCallShareCouponCardUI iPCallShareCouponCardUI, EditText editText, String str, int i) {
        this.nMs = iPCallShareCouponCardUI;
        this.nMt = editText;
        this.iGf = str;
        this.nMu = i;
    }

    public final void gg(boolean z) {
        if (z) {
            k iVar = new i(this.nMu, this.nMt == null ? this.iGf : this.nMt.getText().toString());
            IPCallShareCouponCardUI iPCallShareCouponCardUI = this.nMs;
            Context context = this.nMs;
            this.nMs.getString(R.l.dGO);
            IPCallShareCouponCardUI.b(iPCallShareCouponCardUI, h.a(context, this.nMs.getString(R.l.dGB), true, new 1(this, iVar)));
            ar.CG().a(iVar, 0);
        }
    }
}
