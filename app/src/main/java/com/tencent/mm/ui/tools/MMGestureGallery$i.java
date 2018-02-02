package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.a;

class MMGestureGallery$i extends a {
    float[] mVx = new float[9];
    final /* synthetic */ MMGestureGallery zlk;

    public MMGestureGallery$i(MMGestureGallery mMGestureGallery) {
        this.zlk = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.zlk).post(new 1(this));
    }
}
