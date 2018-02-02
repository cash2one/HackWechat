package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

class t$8 implements o {
    final /* synthetic */ t jFj;

    t$8(t tVar) {
        this.jFj = tVar;
    }

    public final boolean z(MotionEvent motionEvent) {
        return this.jFj.O(motionEvent);
    }

    public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.jFj.b(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void ahE() {
        this.jFj.cyX();
    }

    @TargetApi(9)
    public final void b(int i, int i2, boolean z, boolean z2) {
        this.jFj.c(i, i2, z, z2);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        if (t.i(this.jFj) != null) {
            t.i(this.jFj).onScrollChanged(i, i2, i3, i4, view);
        }
        this.jFj.x(i, i2, i3, i4);
    }

    public final boolean A(MotionEvent motionEvent) {
        return this.jFj.P(motionEvent);
    }

    public final boolean B(MotionEvent motionEvent) {
        return this.jFj.Q(motionEvent);
    }
}
