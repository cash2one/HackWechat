package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class ImagePreviewUI$15 implements a {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$15(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final boolean uF() {
        boolean z;
        ImagePreviewUI imagePreviewUI = this.mUl;
        if (ImagePreviewUI.w(this.mUl)) {
            z = false;
        } else {
            z = true;
        }
        ImagePreviewUI.c(imagePreviewUI, z);
        ImagePreviewUI.a(this.mUl, ImagePreviewUI.w(this.mUl));
        return false;
    }
}
