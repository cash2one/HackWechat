package com.tencent.mm.ui.bindgooglecontact;

import android.webkit.ConsoleMessage;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.j;

class BindGoogleContactUI$3 extends j {
    final /* synthetic */ BindGoogleContactUI ykD;

    BindGoogleContactUI$3(BindGoogleContactUI bindGoogleContactUI) {
        this.ykD = bindGoogleContactUI;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String SU = s.SU(consoleMessage != null ? consoleMessage.message() : null);
        if (!SU.toLowerCase().startsWith("weixin://private/googlegetcode")) {
            return super.onConsoleMessage(consoleMessage);
        }
        BindGoogleContactUI.a(this.ykD, SU);
        return true;
    }
}
