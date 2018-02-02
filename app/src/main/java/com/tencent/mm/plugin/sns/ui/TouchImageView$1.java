package com.tencent.mm.plugin.sns.ui;

class TouchImageView$1 implements Runnable {
    final /* synthetic */ TouchImageView rMZ;

    TouchImageView$1(TouchImageView touchImageView) {
        this.rMZ = touchImageView;
    }

    public final void run() {
        this.rMZ.setPressed(false);
        this.rMZ.invalidate();
    }
}
