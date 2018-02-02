package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class DynamicGridView$3 extends AnimatorListenerAdapter {
    final /* synthetic */ View jLA;
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$3(DynamicGridView dynamicGridView, View view) {
        this.rRm = dynamicGridView;
        this.jLA = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.jLA.setLayerType(0, null);
    }
}
