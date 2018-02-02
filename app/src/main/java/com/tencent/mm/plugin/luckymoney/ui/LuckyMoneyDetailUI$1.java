package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a$e;

class LuckyMoneyDetailUI$1 implements OnScrollListener {
    private boolean ogP = false;
    private boolean ogQ;
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$1(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.ohM = luckyMoneyDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!this.ohM.ogp.aXd()) {
                            LuckyMoneyDetailUI.a(this.ohM);
                        }
                        if (LuckyMoneyDetailUI.b(this.ohM) && !LuckyMoneyDetailUI.c(this.ohM)) {
                            LuckyMoneyDetailUI.d(this.ohM);
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
                    this.ohM.r(this.ohM.getResources().getDrawable(a$e.ucI));
                } else {
                    this.ohM.r(null);
                }
                this.ogQ = z;
            }
        }
    }
}
