package com.tencent.mm.ui.transmit;

import com.tencent.mm.g.a.lh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.i.a.a;
import com.tencent.mm.y.g$a;

class SelectConversationUI$7 implements a {
    final /* synthetic */ g$a jrh;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$7(SelectConversationUI selectConversationUI, g$a com_tencent_mm_y_g_a) {
        this.zpv = selectConversationUI;
        this.jrh = com_tencent_mm_y_g_a;
    }

    public final void aJL() {
        b lhVar = new lh();
        lhVar.fCF.context = this.zpv.mController.xIM;
        lhVar.fCF.fqm = SelectConversationUI.i(this.zpv);
        lhVar.fCF.fCG = this.jrh.hbB;
        lhVar.fCF.fBV = false;
        lhVar.fCF.scene = 7;
        com.tencent.mm.sdk.b.a.xef.m(lhVar);
    }
}
