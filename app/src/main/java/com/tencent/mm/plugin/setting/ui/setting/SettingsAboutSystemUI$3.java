package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;

class SettingsAboutSystemUI$3 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;

    SettingsAboutSystemUI$3(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.qin = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.bi(!a.zc());
        g.Dk().releaseAll();
        ag.y(new 1(this));
    }
}
