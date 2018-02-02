package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.v;

class ImagePreviewUI$9 implements f$b {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$9(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void qB(int i) {
        x.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", Integer.valueOf(i), Boolean.valueOf(ImagePreviewUI.p(this.mUl)));
        ((f) ImagePreviewUI.o(this.mUl).fm()).cE(i, i);
        ImagePreviewUI.q(this.mUl).d(i, false);
        if (ImagePreviewUI.p(this.mUl)) {
            c.mQL = true;
        } else {
            c.mQN = true;
        }
    }

    public final void cD(int i, int i2) {
        x.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), ImagePreviewUI.g(this.mUl));
    }

    public final void L(int i, int i2, int i3) {
        x.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ImagePreviewUI.g(this.mUl));
        if (ImagePreviewUI.p(this.mUl)) {
            c.mQK = true;
            return;
        }
        a.swap(ImagePreviewUI.r(this.mUl), i, i2);
        v h = ImagePreviewUI.h(this.mUl);
        x.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ImagePreviewUI.g(this.mUl).intValue()), Integer.valueOf(i3));
        if (!h.mTi) {
            a.swap(h.mTh, i, i2);
            h.mTk = i3;
            h.mTl = (View) h.yeR.get(r0);
            h.yeP.remove(h.mTl);
            h.yeQ.clear();
            h.yeR.clear();
            h.mTm = true;
            h.notifyDataSetChanged();
        }
        ImagePreviewUI.q(this.mUl).d(i3, false);
        ((f) ImagePreviewUI.o(this.mUl).fm()).cE(i3, i3);
        c.mQM = true;
    }
}
