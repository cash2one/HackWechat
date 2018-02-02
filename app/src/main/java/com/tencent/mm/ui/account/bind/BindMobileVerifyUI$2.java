package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class BindMobileVerifyUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileVerifyUI xTG;

    BindMobileVerifyUI$2(BindMobileVerifyUI bindMobileVerifyUI) {
        this.xTG = bindMobileVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = BindMobileVerifyUI.a(this.xTG).getText().toString().trim();
        if (trim.equals("")) {
            h.h(this.xTG, R.l.dLG, R.l.dGO);
        } else {
            this.xTG.aWs();
            b hoVar = new ho();
            hoVar.fxR.context = this.xTG;
            a.xef.m(hoVar);
            String str = hoVar.fxS.fxT;
            hoVar = new hp();
            a.xef.m(hoVar);
            k tVar = new t(BindMobileVerifyUI.b(this.xTG), 2, trim, "", str, hoVar.fxU.fxV);
            ar.CG().a(tVar, 0);
            BindMobileVerifyUI bindMobileVerifyUI = this.xTG;
            Context context = this.xTG;
            this.xTG.getString(R.l.dGO);
            BindMobileVerifyUI.a(bindMobileVerifyUI, h.a(context, this.xTG.getString(R.l.dLx), true, new 1(this, tVar)));
        }
        return true;
    }
}
