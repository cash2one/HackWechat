package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ak.a;

class MMProgressBar$1 implements a {
    final /* synthetic */ MMProgressBar yco;

    MMProgressBar$1(MMProgressBar mMProgressBar) {
        this.yco = mMProgressBar;
    }

    public final boolean uF() {
        int a = MMProgressBar.a(this.yco) - MMProgressBar.b(this.yco);
        if (a > 0) {
            int i = (int) (((double) a) * 0.6d);
            MMProgressBar mMProgressBar = this.yco;
            int b = MMProgressBar.b(this.yco);
            if (i <= 0) {
                i = 1;
            }
            MMProgressBar.a(mMProgressBar, i + b);
            MMProgressBar.b(this.yco, MMProgressBar.b(this.yco));
            long c = (long) (((MMProgressBar.c(this.yco) - a) * 40) / MMProgressBar.c(this.yco));
            MMProgressBar.d(this.yco).J(c, c);
        }
        return false;
    }
}
