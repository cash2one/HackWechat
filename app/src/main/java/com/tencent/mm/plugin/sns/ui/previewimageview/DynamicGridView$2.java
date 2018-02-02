package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.i.f;

class DynamicGridView$2 implements OnScrollListener {
    private int laG;
    final /* synthetic */ DynamicGridView rRm;
    private int rRn = -1;
    private int rRo = -1;
    private int rRp;
    private int rRq;

    DynamicGridView$2(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.rRp = i;
        this.rRq = i2;
        this.rRn = this.rRn == -1 ? this.rRp : this.rRn;
        this.rRo = this.rRo == -1 ? this.rRq : this.rRo;
        if (!(this.rRp == this.rRn || !DynamicGridView.k(this.rRm) || DynamicGridView.h(this.rRm) == -1)) {
            DynamicGridView.a(this.rRm, DynamicGridView.h(this.rRm));
            DynamicGridView.p(this.rRm);
        }
        if (!(this.rRp + this.rRq == this.rRn + this.rRo || !DynamicGridView.k(this.rRm) || DynamicGridView.h(this.rRm) == -1)) {
            DynamicGridView.a(this.rRm, DynamicGridView.h(this.rRm));
            DynamicGridView.p(this.rRm);
        }
        this.rRn = this.rRp;
        this.rRo = this.rRq;
        if (DynamicGridView.bCC() && DynamicGridView.i(this.rRm)) {
            for (int i4 = 0; i4 < i2; i4++) {
                View childAt = this.rRm.getChildAt(i4);
                if (childAt != null) {
                    if (DynamicGridView.h(this.rRm) != -1 && Boolean.TRUE != childAt.getTag(f.qBX)) {
                        if (i4 % 2 == 0) {
                            DynamicGridView.c(this.rRm, childAt);
                        } else {
                            DynamicGridView.d(this.rRm, childAt);
                        }
                        childAt.setTag(f.qBX, Boolean.valueOf(true));
                    } else if (DynamicGridView.h(this.rRm) == -1 && childAt.getRotation() != 0.0f) {
                        childAt.setRotation(0.0f);
                        childAt.setTag(f.qBX, Boolean.valueOf(false));
                    }
                }
            }
        }
        if (DynamicGridView.j(this.rRm) != null) {
            DynamicGridView.j(this.rRm).onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.laG = i;
        DynamicGridView.c(this.rRm, i);
        if (this.rRq > 0 && this.laG == 0) {
            if (DynamicGridView.k(this.rRm) && DynamicGridView.l(this.rRm)) {
                DynamicGridView.m(this.rRm);
            } else if (DynamicGridView.n(this.rRm)) {
                DynamicGridView.o(this.rRm);
            }
        }
        if (DynamicGridView.j(this.rRm) != null) {
            DynamicGridView.j(this.rRm).onScrollStateChanged(absListView, i);
        }
    }
}
