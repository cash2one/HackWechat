package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$12 implements Runnable {
    final /* synthetic */ ImagePreviewUI mUl;
    final /* synthetic */ long mUn;

    ImagePreviewUI$12(ImagePreviewUI imagePreviewUI, long j) {
        this.mUl = imagePreviewUI;
        this.mUn = j;
    }

    public final void run() {
        ImagePreviewUI.a(this.mUl, true);
        c.aNF().qn(-8);
        x.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", Long.valueOf(bh.bA(this.mUn)));
    }
}
