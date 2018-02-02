package com.tencent.mm.plugin.gallery.ui;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;

class ImagePreviewUI$21 implements Runnable {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$21(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void run() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ImagePreviewUI.a(this.mUl).getLayoutParams();
        marginLayoutParams.topMargin = (int) (((float) j.i(this.mUl)) + this.mUl.getResources().getDimension(R.f.buG));
        ImagePreviewUI.a(this.mUl).setLayoutParams(marginLayoutParams);
    }
}
