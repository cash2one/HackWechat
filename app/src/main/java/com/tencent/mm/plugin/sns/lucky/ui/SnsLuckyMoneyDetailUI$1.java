package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.c;

class SnsLuckyMoneyDetailUI$1 implements OnScrollListener {
    private boolean ogP = false;
    private boolean ogQ;
    final /* synthetic */ SnsLuckyMoneyDetailUI qSf;

    SnsLuckyMoneyDetailUI$1(SnsLuckyMoneyDetailUI snsLuckyMoneyDetailUI) {
        this.qSf = snsLuckyMoneyDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    this.ogP = false;
                    return;
                case 1:
                    this.ogP = true;
                    return;
                default:
                    return;
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = true;
        if (i3 != 0 && this.ogP) {
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.ogQ != z) {
                if (z) {
                    SnsLuckyMoneyDetailUI.a(this.qSf, this.qSf.getResources().getDrawable(c.ubq));
                } else {
                    SnsLuckyMoneyDetailUI.a(this.qSf);
                }
                this.ogQ = z;
            }
        }
    }
}
