package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class CardListSelectedUI$5 implements OnClickListener {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$5(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.kUl.kUi)) {
            b.a(this.kUl, this.kUl.kUi, this.kUl.getString(R.l.dOt));
        }
    }
}
