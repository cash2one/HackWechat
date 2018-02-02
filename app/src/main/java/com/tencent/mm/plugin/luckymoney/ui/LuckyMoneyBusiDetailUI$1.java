package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.e;

class LuckyMoneyBusiDetailUI$1 implements OnScrollListener {
    private boolean ogP = false;
    private boolean ogQ;
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;

    LuckyMoneyBusiDetailUI$1(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.ogR = luckyMoneyBusiDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!this.ogR.ogp.aXd()) {
                            LuckyMoneyBusiDetailUI.a(this.ogR);
                        }
                        if (LuckyMoneyBusiDetailUI.b(this.ogR) && !LuckyMoneyBusiDetailUI.c(this.ogR)) {
                            LuckyMoneyBusiDetailUI.d(this.ogR);
                        }
                    }
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
                    this.ogR.r(this.ogR.getResources().getDrawable(e.ucI));
                } else {
                    this.ogR.r(null);
                }
                this.ogQ = z;
            }
        }
    }
}
