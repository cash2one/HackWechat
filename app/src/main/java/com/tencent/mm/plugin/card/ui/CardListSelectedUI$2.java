package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;

class CardListSelectedUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$2(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.kUl.kTW || !CardListSelectedUI.b(this.kUl).kJZ) {
            CardListSelectedUI.a(this.kUl);
        } else {
            this.kUl.dY(true);
            am.auM().A(CardListSelectedUI.b(this.kUl).kJU, l.wV(CardListSelectedUI.b(this.kUl).userName), 3);
        }
        return true;
    }
}
