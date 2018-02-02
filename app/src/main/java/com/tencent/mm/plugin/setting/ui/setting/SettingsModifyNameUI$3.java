package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

class SettingsModifyNameUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyNameUI qkd;

    SettingsModifyNameUI$3(SettingsModifyNameUI settingsModifyNameUI) {
        this.qkd = settingsModifyNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String obj = SettingsModifyNameUI.c(this.qkd).getText().toString();
        String zI = b.zI();
        if (bh.ov(zI) || !obj.matches(".*[" + zI + "].*")) {
            c.d(SettingsModifyNameUI.c(this.qkd)).fi(1, 32).a(this.qkd);
            return true;
        }
        h.b(this.qkd.mController.xIM, this.qkd.getString(R.l.epE, new Object[]{zI}), this.qkd.getString(R.l.dGO), true);
        return false;
    }
}
