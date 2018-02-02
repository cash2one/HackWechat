package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ShuffleView$1 implements OnLayoutChangeListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$1(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ShuffleView.a(this.obk);
        ShuffleView shuffleView = this.obk;
        for (int i9 = 0; i9 < shuffleView.oaY; i9++) {
            shuffleView.y((View) shuffleView.oaK.get(i9), i9);
        }
        this.obk.removeOnLayoutChangeListener(this);
    }
}
