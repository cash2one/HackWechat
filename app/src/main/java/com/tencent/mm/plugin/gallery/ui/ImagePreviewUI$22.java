package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ImagePreviewUI$22 implements OnClickListener {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$22(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void onClick(View view) {
        ImagePreviewUI.b(this.mUl, !ImagePreviewUI.b(this.mUl));
        if (ImagePreviewUI.b(this.mUl)) {
            ImagePreviewUI.c(this.mUl).setImageResource(R.k.dAr);
            if (ImagePreviewUI.d(this.mUl).size() == 0) {
                ImagePreviewUI.e(this.mUl).performClick();
            }
        } else {
            ImagePreviewUI.c(this.mUl).setImageResource(R.k.dAq);
        }
        ImagePreviewUI.f(this.mUl).setText(this.mUl.mController.xIM.getString(R.l.elh) + ImagePreviewUI.aOy());
        ImagePreviewUI.a(this.mUl, ImagePreviewUI.g(this.mUl).intValue());
    }
}
