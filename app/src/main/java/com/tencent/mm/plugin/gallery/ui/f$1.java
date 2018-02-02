package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.a.a$a;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.f.a;

class f$1 extends a$a {
    int fJA = -1;
    final /* synthetic */ f mUF;

    f$1(f fVar) {
        this.mUF = fVar;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2) {
        int ge = recyclerView$t.ge();
        int ge2 = recyclerView$t2.ge();
        this.mUF.V(ge, ge2);
        if (f.a(this.mUF) != null) {
            f.a(this.mUF).cD(ge, ge2);
        }
        f.a(this.mUF, ge2);
        return false;
    }

    public final void e(RecyclerView$t recyclerView$t, int i) {
        super.e(recyclerView$t, i);
        if (recyclerView$t != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(f.b(this.mUF), R.a.bqh);
            loadAnimation.setAnimationListener(new 1(this, i, recyclerView$t));
            ((a) recyclerView$t).mUL.startAnimation(loadAnimation);
        }
    }

    public final void c(RecyclerView recyclerView, RecyclerView$t recyclerView$t) {
        if (recyclerView$t != null) {
            super.c(recyclerView, recyclerView$t);
            Animation loadAnimation = AnimationUtils.loadAnimation(f.b(this.mUF), R.a.bqg);
            loadAnimation.setAnimationListener(new 2(this));
            ((a) recyclerView$t).mUL.startAnimation(loadAnimation);
        }
    }

    public final void hn() {
    }

    public final float hm() {
        return 0.295858f;
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i, boolean z) {
        super.a(canvas, recyclerView, recyclerView$t, f / 1.3f, f2 / 1.3f, i, z);
    }

    public final int hg() {
        return 3342387;
    }

    public final boolean hi() {
        return true;
    }

    public final boolean hj() {
        return false;
    }
}
