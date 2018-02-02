package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.ui.o.a;

class MassSendHistoryUI$8 implements a {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$8(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final void Xv() {
        MassSendHistoryUI.c(this.onL).mm(MassSendHistoryUI.b(this.onL).awe());
        if (MassSendHistoryUI.b(this.onL).getCount() == 0) {
            MassSendHistoryUI.c(this.onL).setVisibility(8);
            MassSendHistoryUI.e(this.onL).setVisibility(0);
            MassSendHistoryUI.f(this.onL).setVisibility(8);
            return;
        }
        MassSendHistoryUI.c(this.onL).setVisibility(0);
        MassSendHistoryUI.e(this.onL).setVisibility(8);
        MassSendHistoryUI.f(this.onL).setVisibility(0);
    }

    public final void Xw() {
    }
}
