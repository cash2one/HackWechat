package com.tencent.mm.plugin.sns.ui.previewimageview;

import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.h;

class DynamicGridView$g implements h {
    private int Be;
    private int Bf;
    final /* synthetic */ DynamicGridView rRm;

    public DynamicGridView$g(DynamicGridView dynamicGridView, int i, int i2) {
        this.rRm = dynamicGridView;
        this.Be = i;
        this.Bf = i2;
    }

    public final void dK(int i, int i2) {
        DynamicGridView.a(this.rRm, DynamicGridView.e(this.rRm) + this.Bf);
        DynamicGridView.b(this.rRm, DynamicGridView.f(this.rRm) + this.Be);
    }
}
