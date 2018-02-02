package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.bh;

class SayHiWithSnsPermissionUI$3 implements OnFocusChangeListener {
    final /* synthetic */ SayHiWithSnsPermissionUI plm;

    SayHiWithSnsPermissionUI$3(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.plm = sayHiWithSnsPermissionUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z && !bh.M(SayHiWithSnsPermissionUI.b(this.plm).getHint()) && bh.M(SayHiWithSnsPermissionUI.b(this.plm).getText())) {
            SayHiWithSnsPermissionUI.b(this.plm).setText(SayHiWithSnsPermissionUI.b(this.plm).getHint());
            SayHiWithSnsPermissionUI.b(this.plm).setOnFocusChangeListener(null);
            SayHiWithSnsPermissionUI.b(this.plm).setHint(null);
        }
    }
}
