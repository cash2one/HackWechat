package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class SettingsManageAuthUI$1 implements OnScrollListener {
    final /* synthetic */ SettingsManageAuthUI qjE;

    SettingsManageAuthUI$1(SettingsManageAuthUI settingsManageAuthUI) {
        this.qjE = settingsManageAuthUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            x.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
            if (SettingsManageAuthUI.a(this.qjE) != null) {
                SettingsManageAuthUI.aI(SettingsManageAuthUI.a(this.qjE));
                SettingsManageAuthUI.b(this.qjE);
            }
        }
    }
}
