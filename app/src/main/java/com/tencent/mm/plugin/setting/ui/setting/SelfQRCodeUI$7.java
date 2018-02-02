package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.p.a;
import com.tencent.mm.ui.base.p$d;

class SelfQRCodeUI$7 implements p$d {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$7(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                SelfQRCodeUI.e(this.qhD);
                return;
            case 2:
                SelfQRCodeUI.a(this.qhD, 0);
                return;
            case 3:
                if (!a.aV(this.qhD.mController.xIM)) {
                    ActionBarActivity actionBarActivity = this.qhD.mController.xIM;
                    if (!com.tencent.mm.au.a.Qj()) {
                        d.y(this.qhD.mController.xIM, "scanner", ".ui.BaseScanUI");
                        return;
                    }
                    return;
                }
                return;
            case 4:
                SelfQRCodeUI.f(this.qhD);
                return;
            default:
                return;
        }
    }
}
