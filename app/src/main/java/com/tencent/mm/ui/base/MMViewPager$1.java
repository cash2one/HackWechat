package com.tencent.mm.ui.base;

import android.support.v4.view.ViewPager$e;

class MMViewPager$1 implements ViewPager$e {
    final /* synthetic */ MMViewPager yeI;

    MMViewPager$1(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
    }

    public final void ae(int i) {
        if (MMViewPager.e(this.yeI) != null) {
            MMViewPager.e(this.yeI).ae(i);
        }
    }

    public final void a(int i, float f, int i2) {
        if (MMViewPager.e(this.yeI) != null) {
            MMViewPager.e(this.yeI).a(i, f, i2);
        }
        MMViewPager.a(this.yeI, f);
    }

    public final void af(int i) {
        if (MMViewPager.e(this.yeI) != null) {
            MMViewPager.e(this.yeI).af(i);
        }
        if (i == 0) {
            MMViewPager.a(this.yeI, 0.0f);
        }
    }
}
