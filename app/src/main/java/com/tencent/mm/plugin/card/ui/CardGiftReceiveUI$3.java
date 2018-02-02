package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$3 implements OnCancelListener {
    final /* synthetic */ CardGiftReceiveUI kSW;

    CardGiftReceiveUI$3(CardGiftReceiveUI cardGiftReceiveUI) {
        this.kSW = cardGiftReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (CardGiftReceiveUI.c(this.kSW) != null && CardGiftReceiveUI.c(this.kSW).isShowing()) {
            CardGiftReceiveUI.c(this.kSW).dismiss();
        }
        if (CardGiftReceiveUI.d(this.kSW).getVisibility() == 8 || CardGiftReceiveUI.e(this.kSW).getVisibility() == 4) {
            x.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            this.kSW.finish();
        }
    }
}
