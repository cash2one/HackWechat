package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class BindMContactVerifyUI$2 implements OnClickListener {
    final /* synthetic */ BindMContactVerifyUI ylV;

    BindMContactVerifyUI$2(BindMContactVerifyUI bindMContactVerifyUI) {
        this.ylV = bindMContactVerifyUI;
    }

    public final void onClick(View view) {
        String trim = BindMContactVerifyUI.a(this.ylV).getText().toString().trim();
        if (trim.equals("")) {
            h.h(this.ylV, R.l.dLG, R.l.dGO);
            return;
        }
        this.ylV.aWs();
        b hoVar = new ho();
        hoVar.fxR.context = this.ylV;
        a.xef.m(hoVar);
        String str = hoVar.fxS.fxT;
        hoVar = new hp();
        a.xef.m(hoVar);
        String str2 = hoVar.fxU.fxV;
        int i = 2;
        if (BindMContactVerifyUI.b(this.ylV)) {
            i = 19;
        }
        k tVar = new t(BindMContactVerifyUI.c(this.ylV), i, trim, "", str, str2);
        ar.CG().a(tVar, 0);
        BindMContactVerifyUI bindMContactVerifyUI = this.ylV;
        Context context = this.ylV;
        this.ylV.getString(R.l.dGO);
        BindMContactVerifyUI.a(bindMContactVerifyUI, h.a(context, this.ylV.getString(R.l.dLx), true, new 1(this, tVar)));
    }
}
