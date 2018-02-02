package com.tencent.mm.ui.account;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.p.d;

class LoginUI$4 implements d {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$4(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 5001:
                LoginUI.f(this.xPJ);
                return;
            case 5002:
                LoginUI.bq(this.xPJ, this.xPJ.getString(R.l.eXz) + w.cfi());
                return;
            default:
                return;
        }
    }
}
