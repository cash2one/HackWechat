package com.tencent.mm.ui.mogic;

class WxViewPager$3 implements Runnable {
    final /* synthetic */ WxViewPager zfx;

    WxViewPager$3(WxViewPager wxViewPager) {
        this.zfx = wxViewPager;
    }

    public final void run() {
        WxViewPager.a(this.zfx);
        this.zfx.populate();
    }
}
