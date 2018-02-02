package com.tencent.mm.plugin.sns.ui.previewimageview;

import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.h;

class DynamicGridView$b implements h {
    static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
    private int Be;
    private int Bf;
    final /* synthetic */ DynamicGridView rRm;

    public DynamicGridView$b(DynamicGridView dynamicGridView, int i, int i2) {
        this.rRm = dynamicGridView;
        this.Be = i;
        this.Bf = i2;
    }

    public final void dK(int i, int i2) {
        if ($assertionsDisabled || DynamicGridView.g(this.rRm) != null) {
            this.rRm.getViewTreeObserver().addOnPreDrawListener(new a(this, DynamicGridView.g(this.rRm), i, i2));
            DynamicGridView.b(this.rRm, this.rRm.fa(DynamicGridView.h(this.rRm)));
            return;
        }
        throw new AssertionError();
    }
}
