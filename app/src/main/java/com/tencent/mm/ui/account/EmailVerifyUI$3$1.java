package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.ui.account.EmailVerifyUI.3;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class EmailVerifyUI$3$1 implements OnClickListener {
    final /* synthetic */ 3 xNL;

    EmailVerifyUI$3$1(3 3) {
        this.xNL = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k uVar = new u(EmailVerifyUI.a(this.xNL.xNK), EmailVerifyUI.b(this.xNL.xNK));
        ar.CG().a(uVar, 0);
        EmailVerifyUI emailVerifyUI = this.xNL.xNK;
        Context context = this.xNL.xNK;
        this.xNL.xNK.getString(R.l.dGO);
        EmailVerifyUI.a(emailVerifyUI, h.a(context, this.xNL.xNK.getString(R.l.eDq), true, new 1(this, uVar)));
    }
}
