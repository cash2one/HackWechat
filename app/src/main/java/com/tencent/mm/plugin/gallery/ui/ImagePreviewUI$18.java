package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;

class ImagePreviewUI$18 implements a {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$18(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void a(m mVar) {
        if (mVar.position == ImagePreviewUI.g(this.mUl).intValue()) {
            if (mVar.mRD.hOr >= 300000 || (mVar.mRD.hOr > 0 && mVar.mRD.hOr < 1000)) {
                ImagePreviewUI.a(this.mUl).setVisibility(0);
                ImagePreviewUI.x(this.mUl).setText(mVar.mRD.hOr >= 300000 ? this.mUl.getString(R.l.elq) : this.mUl.getString(R.l.els));
                ImagePreviewUI.y(this.mUl).setEnabled(false);
                ImagePreviewUI.e(this.mUl).setEnabled(false);
                ImagePreviewUI.y(this.mUl).setTextColor(this.mUl.getResources().getColor(R.e.buk));
                if (ImagePreviewUI.d(this.mUl).size() == 0) {
                    this.mUl.enableOptionMenu(false);
                    return;
                }
                return;
            }
            ImagePreviewUI.y(this.mUl).setEnabled(true);
            ImagePreviewUI.e(this.mUl).setEnabled(true);
            ImagePreviewUI.y(this.mUl).setTextColor(this.mUl.getResources().getColor(R.e.buj));
            ImagePreviewUI.a(this.mUl).setVisibility(8);
        }
    }
}
