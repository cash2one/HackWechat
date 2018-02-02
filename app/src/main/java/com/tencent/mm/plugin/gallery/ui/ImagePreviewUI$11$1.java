package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.11;
import java.util.Collection;

class ImagePreviewUI$11$1 implements Runnable {
    final /* synthetic */ 11 mUm;

    ImagePreviewUI$11$1(11 11) {
        this.mUm = 11;
    }

    public final void run() {
        ImagePreviewUI.h(this.mUm.mUl).B(ImagePreviewUI.r(this.mUm.mUl));
        f fVar = (f) ImagePreviewUI.o(this.mUm.mUl).fm();
        Collection r = ImagePreviewUI.r(this.mUm.mUl);
        fVar.mUw.clear();
        fVar.mUw.addAll(r);
        fVar.UR.notifyChanged();
        Collection stringArrayListExtra = this.mUm.kvq.getStringArrayListExtra("preview_select_image_list");
        ImagePreviewUI.d(this.mUm.mUl).clear();
        if (stringArrayListExtra != null) {
            ImagePreviewUI.d(this.mUm.mUl).addAll(stringArrayListExtra);
        }
        this.mUm.mUl.updateOptionMenuText(0, ImagePreviewUI.m(this.mUm.mUl));
        ImagePreviewUI.f(this.mUm.mUl).setText(this.mUm.mUl.mController.xIM.getString(R.l.elh) + ImagePreviewUI.aOy());
    }
}
