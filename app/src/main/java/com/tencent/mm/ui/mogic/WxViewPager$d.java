package com.tencent.mm.ui.mogic;

import android.database.DataSetObserver;

class WxViewPager$d extends DataSetObserver {
    final /* synthetic */ WxViewPager zfx;

    private WxViewPager$d(WxViewPager wxViewPager) {
        this.zfx = wxViewPager;
    }

    public final void onChanged() {
        this.zfx.bR();
    }

    public final void onInvalidated() {
        this.zfx.bR();
    }
}
