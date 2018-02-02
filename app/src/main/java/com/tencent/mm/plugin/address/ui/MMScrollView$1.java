package com.tencent.mm.plugin.address.ui;

import android.view.View;
import com.tencent.mm.bv.a;

class MMScrollView$1 implements Runnable {
    final /* synthetic */ MMScrollView inA;
    final /* synthetic */ View zS;

    MMScrollView$1(MMScrollView mMScrollView, View view) {
        this.inA = mMScrollView;
        this.zS = view;
    }

    public final void run() {
        this.inA.scrollTo(0, this.zS.getTop() - a.fromDPToPix(this.inA.getContext(), 10));
    }
}
