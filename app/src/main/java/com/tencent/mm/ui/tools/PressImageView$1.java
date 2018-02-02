package com.tencent.mm.ui.tools;

class PressImageView$1 implements Runnable {
    final /* synthetic */ PressImageView zmf;

    PressImageView$1(PressImageView pressImageView) {
        this.zmf = pressImageView;
    }

    public final void run() {
        this.zmf.setPressed(false);
        this.zmf.invalidate();
    }
}
