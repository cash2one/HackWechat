package com.tencent.mm.plugin.card.base;

import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.ui.base.h.c;

class CardBaseUI$5 implements c {
    final /* synthetic */ CardBaseUI kIn;
    final /* synthetic */ String kIo;
    final /* synthetic */ b kIp;

    CardBaseUI$5(CardBaseUI cardBaseUI, b bVar, String str) {
        this.kIn = cardBaseUI;
        this.kIp = bVar;
        this.kIo = str;
    }

    public final void jl(int i) {
        if (this.kIp.ato()) {
            switch (i) {
                case 0:
                    this.kIn.a((CardInfo) this.kIp);
                    return;
                case 1:
                    CardBaseUI.b(this.kIn, this.kIo);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 0:
                CardBaseUI.b(this.kIn, this.kIo);
                return;
            default:
                return;
        }
    }
}
