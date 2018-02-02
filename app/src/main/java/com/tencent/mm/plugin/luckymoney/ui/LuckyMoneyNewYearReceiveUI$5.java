package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class LuckyMoneyNewYearReceiveUI$5 implements Runnable {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI oiL;

    LuckyMoneyNewYearReceiveUI$5(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.oiL = luckyMoneyNewYearReceiveUI;
    }

    public final void run() {
        if (new File(LuckyMoneyNewYearReceiveUI.h(this.oiL)).exists()) {
            final Bitmap aq = n.aq(LuckyMoneyNewYearReceiveUI.h(this.oiL), true);
            ag.y(new Runnable(this) {
                final /* synthetic */ LuckyMoneyNewYearReceiveUI$5 oiO;

                public final void run() {
                    LuckyMoneyNewYearReceiveUI.i(this.oiO.oiL).setImageBitmap(aq);
                }

                public final String toString() {
                    return super.toString() + "|renderView";
                }
            });
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + LuckyMoneyNewYearReceiveUI.h(this.oiL) + " is not exist!");
    }
}
