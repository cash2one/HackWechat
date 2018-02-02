package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class SendAppMessageWrapperUI$4 implements a {
    final /* synthetic */ SendAppMessageWrapperUI zpD;

    SendAppMessageWrapperUI$4(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.zpD = sendAppMessageWrapperUI;
    }

    public final void a(boolean z, String str, int i) {
        this.zpD.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
        this.zpD.finish();
    }
}
