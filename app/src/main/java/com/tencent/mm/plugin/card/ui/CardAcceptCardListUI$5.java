package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class CardAcceptCardListUI$5 implements OnClickListener {
    final /* synthetic */ CardAcceptCardListUI kQf;

    CardAcceptCardListUI$5(CardAcceptCardListUI cardAcceptCardListUI) {
        this.kQf = cardAcceptCardListUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        CardAcceptCardListUI.a(this.kQf, 2);
    }
}
