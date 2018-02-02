package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;

class ImagePreviewUI$8 implements Runnable {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$8(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void run() {
        int i = this.mUl.getResources().getDisplayMetrics().widthPixels / 7;
        ImagePreviewUI.o(this.mUl).getLayoutParams().height = (((int) ac.getContext().getResources().getDimension(R.f.bvv)) * 2) + i;
        ImagePreviewUI.o(this.mUl).smoothScrollToPosition(ImagePreviewUI.g(this.mUl).intValue());
    }
}
