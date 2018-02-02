package com.tencent.mm.ui.transmit;

import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class SendAppMessageWrapperUI$5 implements a {
    final /* synthetic */ SendAppMessageWrapperUI zpD;

    SendAppMessageWrapperUI$5(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.zpD = sendAppMessageWrapperUI;
    }

    public final void a(boolean z, String str, int i) {
        this.zpD.setResult(-1);
        this.zpD.finish();
        ReportUtil.a(this.zpD, ReportUtil.b(this.zpD.getIntent().getExtras(), 0));
    }
}
