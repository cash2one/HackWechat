package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.ui.base.h.c;

class CardNewMsgUI$7 implements c {
    final /* synthetic */ int hvX;
    final /* synthetic */ CardNewMsgUI kUG;

    CardNewMsgUI$7(CardNewMsgUI cardNewMsgUI, int i) {
        this.kUG = cardNewMsgUI;
        this.hvX = i;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                g gVar = (g) CardNewMsgUI.a(this.kUG).getItem(this.hvX);
                if (gVar != null) {
                    am.auE().wc(gVar.field_msg_id);
                    CardNewMsgUI.g(this.kUG);
                    CardNewMsgUI.a(this.kUG).a(null, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
