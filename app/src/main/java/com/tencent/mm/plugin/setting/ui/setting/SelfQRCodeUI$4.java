package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class SelfQRCodeUI$4 implements OnClickListener {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$4(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final void onClick(View view) {
        d.y(this.qhD, "setting", ".ui.setting.SettingsAddMeUI");
    }
}
