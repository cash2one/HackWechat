package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.b;

class DynamicGridView$b$a implements OnPreDrawListener {
    private final int Vv;
    private final View rRt;
    private final int rRu;
    final /* synthetic */ b rRv;

    DynamicGridView$b$a(b bVar, View view, int i, int i2) {
        this.rRv = bVar;
        this.rRt = view;
        this.rRu = i;
        this.Vv = i2;
    }

    public final boolean onPreDraw() {
        this.rRv.rRm.getViewTreeObserver().removeOnPreDrawListener(this);
        this.rRv.rRm.rQF = this.rRv.rRm.rQF + b.a(this.rRv);
        this.rRv.rRm.rQG = this.rRv.rRm.rQG + b.b(this.rRv);
        DynamicGridView.a(this.rRv.rRm, this.rRu, this.Vv);
        this.rRt.setVisibility(0);
        if (this.rRv.rRm.rRe != null) {
            this.rRv.rRm.rRe.setVisibility(4);
        }
        return true;
    }
}
