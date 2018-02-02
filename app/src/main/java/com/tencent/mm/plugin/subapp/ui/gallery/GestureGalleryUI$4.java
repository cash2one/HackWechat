package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

class GestureGalleryUI$4 implements c {
    final /* synthetic */ GestureGalleryUI rXs;
    final /* synthetic */ int rXt;

    GestureGalleryUI$4(GestureGalleryUI gestureGalleryUI, int i) {
        this.rXs = gestureGalleryUI;
        this.rXt = i;
    }

    public final void aJi() {
        if (1 == this.rXt) {
            GestureGalleryUI.a(this.rXs);
        } else if (2 == this.rXt) {
            h.a(this.rXs, null, this.rXs.mController.xIM.getResources().getStringArray(R.c.bqZ), "", false, new 1(this));
        }
    }
}
