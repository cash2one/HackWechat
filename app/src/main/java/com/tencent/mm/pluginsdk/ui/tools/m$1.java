package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class m$1 implements OnLayoutChangeListener {
    final /* synthetic */ View vyy;

    m$1(View view) {
        this.vyy = view;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        int i10 = i8 - i6;
        if (i9 > 0 && i10 != i9) {
            view.post(new 1(this, view));
        }
    }
}
