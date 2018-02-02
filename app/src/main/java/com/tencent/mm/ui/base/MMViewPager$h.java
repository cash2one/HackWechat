package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.a;

class MMViewPager$h extends a {
    float[] mVx = new float[9];
    final /* synthetic */ MMViewPager yeI;

    public MMViewPager$h(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
        super(mMViewPager);
    }

    public final void play() {
        MMViewPager.c(this.yeI).post(new 1(this));
    }
}
