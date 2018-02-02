package com.tencent.mm.plugin.game.gamewebview.e;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.game.gamewebview.ui.f;

class b$b extends f {
    final /* synthetic */ b naI;

    private b$b(b bVar) {
        this.naI = bVar;
    }

    public final boolean z(MotionEvent motionEvent) {
        return this.naI.O(motionEvent);
    }

    public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.naI.b(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final boolean A(MotionEvent motionEvent) {
        return this.naI.P(motionEvent);
    }

    public final void ahE() {
        this.naI.cyX();
    }

    @TargetApi(9)
    public final void b(int i, int i2, boolean z, boolean z2) {
        this.naI.c(i, i2, z, z2);
    }

    public final boolean B(MotionEvent motionEvent) {
        return this.naI.Q(motionEvent);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        this.naI.x(i, i2, i3, i4);
        if (b.i(this.naI) != null) {
            b.i(this.naI).onScrollChanged(i, i2, i3, i4, view);
        }
    }
}
