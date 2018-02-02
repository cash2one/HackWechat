package com.tencent.mm.plugin.sns.ui;

class MaskImageView$1 implements Runnable {
    final /* synthetic */ MaskImageView ruq;

    MaskImageView$1(MaskImageView maskImageView) {
        this.ruq = maskImageView;
    }

    public final void run() {
        this.ruq.setPressed(false);
        this.ruq.invalidate();
    }
}
