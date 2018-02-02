package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class SettingsSearchAuthUI$3 implements OnClickListener {
    final /* synthetic */ SettingsSearchAuthUI qkQ;

    SettingsSearchAuthUI$3(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.qkQ = settingsSearchAuthUI;
    }

    public final void onClick(View view) {
        CharSequence text = SettingsSearchAuthUI.d(this.qkQ).zet.yig.getText();
        if (!bh.M(text)) {
            SettingsSearchAuthUI.a(this.qkQ, text.toString().trim());
        }
    }
}
