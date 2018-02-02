package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class SetPwdUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SetPwdUI xSw;

    SetPwdUI$2(SetPwdUI setPwdUI) {
        this.xSw = setPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.xSw.cod() && this.xSw.qoX) {
            x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
            g.pQN.h(11868, Integer.valueOf(1));
        }
        this.xSw.aWs();
        this.xSw.setResult(0);
        this.xSw.finish();
        return true;
    }
}
