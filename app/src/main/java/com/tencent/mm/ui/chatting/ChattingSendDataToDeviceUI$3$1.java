package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.3;

class ChattingSendDataToDeviceUI$3$1 implements Runnable {
    final /* synthetic */ f nbv;
    final /* synthetic */ 3 yva;

    ChattingSendDataToDeviceUI$3$1(3 3, f fVar) {
        this.yva = 3;
        this.nbv = fVar;
    }

    public final void run() {
        g.a(this.yva.yuZ.getBaseContext(), this.nbv.field_packageName, this.yva.yuZ.yuW, this.nbv.field_appId, this.nbv.field_openId, 0, null, null);
    }
}
