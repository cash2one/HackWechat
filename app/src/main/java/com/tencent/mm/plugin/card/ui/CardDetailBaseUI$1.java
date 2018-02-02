package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class CardDetailBaseUI$1 implements OnClickListener {
    final /* synthetic */ OnMenuItemClickListener kQr;
    final /* synthetic */ CardDetailBaseUI kQs;

    CardDetailBaseUI$1(CardDetailBaseUI cardDetailBaseUI, OnMenuItemClickListener onMenuItemClickListener) {
        this.kQs = cardDetailBaseUI;
        this.kQr = onMenuItemClickListener;
    }

    public final void onClick(View view) {
        if (this.kQr != null) {
            this.kQr.onMenuItemClick(null);
        }
    }
}
