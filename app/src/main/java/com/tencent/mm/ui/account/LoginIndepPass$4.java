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

class LoginIndepPass$4 implements OnClickListener {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$4(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(this.xPi).xPq + " img len" + LoginIndepPass.e(this.xPi).xPs.length + " " + g.zh());
        k vVar = new v(LoginIndepPass.e(this.xPi).hNv, LoginIndepPass.e(this.xPi).xPo, LoginIndepPass.e(this.xPi).xPt, LoginIndepPass.f(this.xPi).coF(), LoginIndepPass.f(this.xPi).xPq, LoginIndepPass.f(this.xPi).xPr, 1, "", false, false);
        ar.CG().a(vVar, 0);
        LoginIndepPass loginIndepPass = this.xPi;
        Context context = this.xPi;
        this.xPi.getString(R.l.dGO);
        LoginIndepPass.a(loginIndepPass, h.a(context, this.xPi.getString(R.l.etF), true, new 1(this, vVar)));
    }
}
