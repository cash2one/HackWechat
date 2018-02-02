package com.tencent.mm.ui.transmit;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class SendAppMessageWrapperUI$3 implements a {
    final /* synthetic */ WXMediaMessage fgT;
    final /* synthetic */ SendAppMessageWrapperUI zpD;

    SendAppMessageWrapperUI$3(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage) {
        this.zpD = sendAppMessageWrapperUI;
        this.fgT = wXMediaMessage;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            SendAppMessageWrapperUI.a(this.zpD, this.fgT, str, i);
        } else {
            SendAppMessageWrapperUI.d(this.zpD);
        }
    }
}
