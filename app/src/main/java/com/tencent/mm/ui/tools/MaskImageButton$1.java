package com.tencent.mm.ui.tools;

class MaskImageButton$1 implements Runnable {
    final /* synthetic */ MaskImageButton zlI;

    MaskImageButton$1(MaskImageButton maskImageButton) {
        this.zlI = maskImageButton;
    }

    public final void run() {
        this.zlI.setPressed(false);
        this.zlI.invalidate();
    }
}
