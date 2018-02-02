package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class ProtocolThreeOneUI$5 implements a {
    final /* synthetic */ ProtocolThreeOneUI mIQ;
    private int mIu = -999999999;

    ProtocolThreeOneUI$5(ProtocolThreeOneUI protocolThreeOneUI) {
        this.mIQ = protocolThreeOneUI;
    }

    public final void a(String str, l lVar) {
        ProtocolThreeOneUI.a(this.mIQ, this.mIQ.aMt());
        if (this.mIu != ProtocolThreeOneUI.a(this.mIQ)) {
            this.mIu = ProtocolThreeOneUI.a(this.mIQ);
            this.mIQ.pZ(ProtocolThreeOneUI.a(this.mIQ));
        }
    }
}
