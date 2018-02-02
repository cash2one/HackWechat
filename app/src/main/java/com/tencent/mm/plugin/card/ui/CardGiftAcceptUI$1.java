package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftAcceptUI$1 implements OnCancelListener {
    final /* synthetic */ CardGiftAcceptUI kRS;

    CardGiftAcceptUI$1(CardGiftAcceptUI cardGiftAcceptUI) {
        this.kRS = cardGiftAcceptUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (CardGiftAcceptUI.a(this.kRS) != null && CardGiftAcceptUI.a(this.kRS).isShowing()) {
            CardGiftAcceptUI.a(this.kRS).dismiss();
        }
        x.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        this.kRS.finish();
    }
}
