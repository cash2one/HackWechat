package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a;
import com.tencent.mm.ui.base.MultiTouchImageView;

class MultiGestureImageView$g extends a {
    final /* synthetic */ MultiGestureImageView mVw;
    float[] mVx = new float[9];
    MultiTouchImageView mVy;

    public MultiGestureImageView$g(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
        this.mVw = multiGestureImageView;
        super(multiGestureImageView);
        this.mVy = multiTouchImageView;
    }

    public final void play() {
        MultiGestureImageView.h(this.mVw).getHandler().post(new 1(this));
    }
}
