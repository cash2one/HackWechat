package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.ViewPager.e;

class WalletPayUOpenIntroView$1 implements e {
    final /* synthetic */ WalletPayUOpenIntroView tch;

    WalletPayUOpenIntroView$1(WalletPayUOpenIntroView walletPayUOpenIntroView) {
        this.tch = walletPayUOpenIntroView;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        if (WalletPayUOpenIntroView.a(this.tch).getParent() != null) {
            WalletPayUOpenIntroView.a(this.tch).getParent().requestDisallowInterceptTouchEvent(true);
        }
        WalletPayUOpenIntroView.b(this.tch).xa(i);
    }

    public final void af(int i) {
    }
}
