package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.4;
import com.tencent.mm.ui.base.h.c;

class LuckyMoneyMyRecordUI$4$1 implements c {
    final /* synthetic */ int ois;
    final /* synthetic */ 4 oit;

    LuckyMoneyMyRecordUI$4$1(4 4, int i) {
        this.oit = 4;
        this.ois = i;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                h sh = LuckyMoneyMyRecordUI.f(this.oit.oiq).sh(this.ois);
                if (sh != null) {
                    LuckyMoneyMyRecordUI.b(this.oit.oiq, this.ois);
                    LuckyMoneyMyRecordUI.a(this.oit.oiq, sh, this.ois);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
