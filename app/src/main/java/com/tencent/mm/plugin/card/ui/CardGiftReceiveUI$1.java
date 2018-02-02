package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$1 implements OnGlobalLayoutListener {
    final /* synthetic */ CardGiftReceiveUI kSW;

    CardGiftReceiveUI$1(CardGiftReceiveUI cardGiftReceiveUI) {
        this.kSW = cardGiftReceiveUI;
    }

    public final void onGlobalLayout() {
        x.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[]{Integer.valueOf(a.fromDPToPix(this.kSW.mController.xIM, 67)), Integer.valueOf(CardGiftReceiveUI.a(this.kSW).getChildAt(0).getHeight() + a.fromDPToPix(this.kSW.mController.xIM, 67)), Integer.valueOf(this.kSW.getWindow().findViewById(16908290).getHeight())});
        CardGiftReceiveUI.a(this.kSW).setFillViewport(true);
        if (CardGiftReceiveUI.a(this.kSW).getChildAt(0).getHeight() + a.fromDPToPix(this.kSW.mController.xIM, 67) > this.kSW.getWindow().findViewById(16908290).getHeight()) {
            CardGiftReceiveUI.a(this.kSW, true);
        } else {
            CardGiftReceiveUI.a(this.kSW, false);
        }
        CardGiftReceiveUI.a(this.kSW).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
