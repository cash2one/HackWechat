package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class LoginSmsUI$1 implements OnClickListener {
    final /* synthetic */ LoginSmsUI xPx;

    LoginSmsUI$1(LoginSmsUI loginSmsUI) {
        this.xPx = loginSmsUI;
    }

    public final void onClick(View view) {
        h.a(this.xPx, this.xPx.getString(R.l.eDX) + this.xPx.xOC, this.xPx.getString(R.l.eDY), this.xPx.getString(R.l.dFU), this.xPx.getString(R.l.dEn), false, new 1(this), new 2(this));
    }
}
