package com.tencent.mm.plugin.luckymoney.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyWishFooter$4 implements ChatFooterPanel$a {
    final /* synthetic */ LuckyMoneyWishFooter okD;

    LuckyMoneyWishFooter$4(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.okD = luckyMoneyWishFooter;
    }

    public final void aXU() {
    }

    public final void gw(boolean z) {
    }

    public final void amZ() {
        LuckyMoneyWishFooter.a(this.okD).ztO.sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.a(this.okD).ztO.sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            LuckyMoneyWishFooter.a(this.okD).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
        }
    }
}
