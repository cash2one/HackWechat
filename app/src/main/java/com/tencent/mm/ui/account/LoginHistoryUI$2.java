package com.tencent.mm.ui.account;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.p.d;

class LoginHistoryUI$2 implements d {
    final /* synthetic */ LoginHistoryUI xPa;

    LoginHistoryUI$2(LoginHistoryUI loginHistoryUI) {
        this.xPa = loginHistoryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 7002:
                LoginHistoryUI.d(this.xPa);
                return;
            case 7003:
                LoginHistoryUI.e(this.xPa);
                return;
            case 7004:
                LoginHistoryUI.f(this.xPa);
                return;
            case 7009:
                LoginHistoryUI.bp(this.xPa, this.xPa.getString(R.l.eXz) + w.cfi());
                return;
            default:
                return;
        }
    }
}
