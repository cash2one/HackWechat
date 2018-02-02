package com.tencent.mm.plugin.safedevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SecurityAccountIntroUI$1 implements OnClickListener {
    final /* synthetic */ SecurityAccountIntroUI pRR;

    SecurityAccountIntroUI$1(SecurityAccountIntroUI securityAccountIntroUI) {
        this.pRR = securityAccountIntroUI;
    }

    public final void onClick(View view) {
        k tVar;
        if (SecurityAccountIntroUI.a(this.pRR)) {
            tVar = new t(SecurityAccountIntroUI.b(this.pRR), 10, "", 0, "");
        } else {
            tVar = new s(SecurityAccountIntroUI.b(this.pRR), 10, "", 0, "", SecurityAccountIntroUI.c(this.pRR));
        }
        ar.CG().a(tVar, 0);
        SecurityAccountIntroUI securityAccountIntroUI = this.pRR;
        Context context = this.pRR;
        this.pRR.getString(R.l.dGO);
        SecurityAccountIntroUI.a(securityAccountIntroUI, h.a(context, this.pRR.getString(R.l.eGX), true, new 1(this, tVar)));
    }
}
