package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

class SelectConversationUI$1 implements a {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$1(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final void dP(boolean z) {
        boolean isFinishing = this.zpv.isFinishing();
        x.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
        if (!z && !isFinishing) {
            this.zpv.finish();
        }
    }
}
