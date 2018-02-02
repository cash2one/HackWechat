package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView$g;

class MassSendHistoryUI$5 implements MMPullDownView$g {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$5(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final boolean azn() {
        int i = 0;
        if (MassSendHistoryUI.b(this.onL).awe()) {
            MassSendHistoryUI.d(this.onL).setSelectionFromTop(0, MassSendHistoryUI.c(this.onL).ycr);
        } else {
            c b = MassSendHistoryUI.b(this.onL);
            if (!b.awe()) {
                b.kUH += 10;
                if (b.kUH <= b.hKb) {
                    i = 10;
                } else {
                    b.kUH = b.hKb;
                    i = b.hKb % 10;
                }
            }
            x.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
            MassSendHistoryUI.b(this.onL).a(null, null);
            MassSendHistoryUI.d(this.onL).setSelectionFromTop(i, MassSendHistoryUI.c(this.onL).ycr);
        }
        return true;
    }
}
