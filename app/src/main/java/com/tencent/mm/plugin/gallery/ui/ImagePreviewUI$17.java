package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;

class ImagePreviewUI$17 implements a {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$17(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void a(m mVar) {
        if (mVar.position == ImagePreviewUI.g(this.mUl).intValue()) {
            ImagePreviewUI.a(this.mUl, mVar.path, mVar.mRD);
        }
    }
}
