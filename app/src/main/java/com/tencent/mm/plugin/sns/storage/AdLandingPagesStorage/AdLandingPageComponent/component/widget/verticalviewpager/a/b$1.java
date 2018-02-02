package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;

class b$1 extends k {
    final /* synthetic */ b rnf;

    b$1(b bVar) {
        this.rnf = bVar;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        if (b.a(this.rnf).rnp != null && b.a(this.rnf).rnp.getVisibility() == 0) {
            b.a(this.rnf).rnp.scrollBy(i, i2);
        }
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        b.a(this.rnf, i);
        if (i == 0) {
            if (b.b(this.rnf)) {
                this.rnf.bxJ();
            }
        } else if (i == 1) {
            this.rnf.bxI();
            ac.dw(this.rnf.getContext());
        }
    }
}
