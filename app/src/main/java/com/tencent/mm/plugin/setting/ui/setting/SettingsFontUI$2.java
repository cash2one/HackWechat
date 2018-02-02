package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class SettingsFontUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsFontUI qjs;

    SettingsFontUI$2(SettingsFontUI settingsFontUI) {
        this.qjs = settingsFontUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(11609, new Object[]{Integer.valueOf(SettingsFontUI.a(this.qjs)), Integer.valueOf(SettingsFontUI.b(this.qjs)), Integer.valueOf(0)});
        x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(this.qjs)), Integer.valueOf(SettingsFontUI.b(this.qjs))});
        this.qjs.finish();
        SettingsFontUI.a(this.qjs, this.qjs.qjo);
        return true;
    }
}
