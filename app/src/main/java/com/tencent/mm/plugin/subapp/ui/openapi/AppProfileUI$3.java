package com.tencent.mm.plugin.subapp.ui.openapi;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class AppProfileUI$3 extends af {
    final /* synthetic */ AppProfileUI rXM;

    AppProfileUI$3(AppProfileUI appProfileUI) {
        this.rXM = appProfileUI;
    }

    public final void handleMessage(Message message) {
        this.rXM.finish();
    }
}
