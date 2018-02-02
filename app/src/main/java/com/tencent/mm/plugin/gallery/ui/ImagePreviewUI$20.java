package com.tencent.mm.plugin.gallery.ui;

class ImagePreviewUI$20 implements Runnable {
    final /* synthetic */ ImagePreviewUI mUl;
    final /* synthetic */ int mUq;

    ImagePreviewUI$20(ImagePreviewUI imagePreviewUI, int i) {
        this.mUl = imagePreviewUI;
        this.mUq = i;
    }

    public final void run() {
        ImagePreviewUI.o(this.mUl).smoothScrollToPosition(this.mUq);
    }
}
