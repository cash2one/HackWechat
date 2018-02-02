package com.tencent.mm.plugin.gallery.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.ui.h.a;

class a$1 implements a {
    final /* synthetic */ ImageView mRR;
    final /* synthetic */ a mRS;

    a$1(a aVar, ImageView imageView) {
        this.mRS = aVar;
        this.mRR = imageView;
    }

    public final void aOn() {
        if (this.mRR != null) {
            this.mRR.setVisibility(8);
        }
    }
}
