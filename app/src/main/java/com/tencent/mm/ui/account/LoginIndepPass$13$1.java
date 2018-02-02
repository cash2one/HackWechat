package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.ui.account.LoginIndepPass.13;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class LoginIndepPass$13$1 implements OnClickListener {
    final /* synthetic */ 13 xPk;

    LoginIndepPass$13$1(13 13) {
        this.xPk = 13;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(c.CTRL_INDEX, this.xPk.xPi);
        k sVar = new s(LoginIndepPass.d(this.xPk.xPi), 16, "", 0, "");
        ar.CG().a(sVar, 0);
        LoginIndepPass loginIndepPass = this.xPk.xPi;
        Context context = this.xPk.xPi;
        this.xPk.xPi.getString(R.l.dGO);
        LoginIndepPass.a(loginIndepPass, h.a(context, this.xPk.xPi.getString(R.l.eLF), true, new 1(this, sVar)));
    }
}
