package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.FrameLayout.LayoutParams;

class AdVideoPlayerLoadingBar$2 implements Runnable {
    final /* synthetic */ AdVideoPlayerLoadingBar quz;

    AdVideoPlayerLoadingBar$2(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar) {
        this.quz = adVideoPlayerLoadingBar;
    }

    public final void run() {
        LayoutParams layoutParams = (LayoutParams) this.quz.qun.getLayoutParams();
        layoutParams.leftMargin = (((LayoutParams) this.quz.qum.getLayoutParams()).leftMargin - this.quz.qun.getPaddingLeft()) - (((this.quz.bta() - this.quz.qun.getPaddingLeft()) - this.quz.qun.getPaddingRight()) / 2);
        this.quz.qun.setLayoutParams(layoutParams);
    }
}
