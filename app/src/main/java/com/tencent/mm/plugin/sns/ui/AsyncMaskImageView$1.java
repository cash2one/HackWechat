package com.tencent.mm.plugin.sns.ui;

class AsyncMaskImageView$1 implements Runnable {
    final /* synthetic */ AsyncMaskImageView rra;

    AsyncMaskImageView$1(AsyncMaskImageView asyncMaskImageView) {
        this.rra = asyncMaskImageView;
    }

    public final void run() {
        this.rra.setPressed(false);
        this.rra.invalidate();
    }
}
