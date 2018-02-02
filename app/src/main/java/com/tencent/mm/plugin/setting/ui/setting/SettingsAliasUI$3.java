package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;

class SettingsAliasUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasUI qjd;

    SettingsAliasUI$3(SettingsAliasUI settingsAliasUI) {
        this.qjd = settingsAliasUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsAliasUI.a(this.qjd, SettingsAliasUI.c(this.qjd).getText().toString().trim());
        if (q.FS().equalsIgnoreCase(SettingsAliasUI.d(this.qjd))) {
            this.qjd.aWs();
            this.qjd.finish();
        } else {
            h.a(this.qjd.mController.xIM, this.qjd.getString(R.l.evy, new Object[]{SettingsAliasUI.d(this.qjd)}), this.qjd.getString(R.l.dUi), new 1(this), null);
        }
        return true;
    }
}
