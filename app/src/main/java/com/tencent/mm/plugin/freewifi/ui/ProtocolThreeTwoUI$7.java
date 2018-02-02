package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class ProtocolThreeTwoUI$7 implements a {
    final /* synthetic */ ProtocolThreeTwoUI mIW;
    private int mIu = -999999999;

    ProtocolThreeTwoUI$7(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void a(String str, l lVar) {
        ProtocolThreeTwoUI.a(this.mIW, this.mIW.aMt());
        if (this.mIu != ProtocolThreeTwoUI.a(this.mIW)) {
            this.mIu = ProtocolThreeTwoUI.a(this.mIW);
            this.mIW.pZ(ProtocolThreeTwoUI.a(this.mIW));
        }
    }
}
