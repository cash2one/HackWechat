package com.tencent.mm.plugin.card.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$4 implements OnScrollListener {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$4(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.kUl.kMn) {
            x.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(this.kUl);
        }
    }
}
