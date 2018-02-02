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

class LoginUI$14 implements OnClickListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$14(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (LoginUI.j(this.xPJ) == null) {
            x.e("MicroMsg.LoginUI", "secimg is null!");
            return;
        }
        x.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.k(this.xPJ).xPq + " img len" + LoginUI.k(this.xPJ).xPs.length + " " + g.zh());
        k vVar = new v(LoginUI.k(this.xPJ).hNv, LoginUI.k(this.xPJ).xPo, LoginUI.k(this.xPJ).xPt, LoginUI.j(this.xPJ).coF(), LoginUI.j(this.xPJ).xPq, LoginUI.j(this.xPJ).xPr, 2, "", false, false);
        ar.CG().a(vVar, 0);
        LoginUI loginUI = this.xPJ;
        Context context = this.xPJ;
        this.xPJ.getString(R.l.dGO);
        LoginUI.a(loginUI, h.a(context, this.xPJ.getString(R.l.etF), true, new 1(this, vVar)));
    }
}
