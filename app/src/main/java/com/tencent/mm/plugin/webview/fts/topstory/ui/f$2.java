package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoViewControlBar.a;

class f$2 implements a {
    final /* synthetic */ f tpL;

    f$2(f fVar) {
        this.tpL = fVar;
    }

    public final void update(int i, int i2) {
        int width;
        if (i2 > 0) {
            width = (f.n(this.tpL).getWidth() * i) / i2;
        } else {
            width = 0;
        }
        LayoutParams layoutParams = (LayoutParams) f.o(this.tpL).getLayoutParams();
        layoutParams.width = width;
        f.o(this.tpL).setLayoutParams(layoutParams);
        f.o(this.tpL).requestLayout();
    }

    public final void bPZ() {
        f.p(this.tpL).setVisibility(8);
    }

    public final void bQa() {
        if (!g.bQd().tpZ || (!(g.bQd().bQg() || g.bQd().tqa) || d.bPB().nbV)) {
            f.p(this.tpL).setVisibility(8);
        } else {
            f.p(this.tpL).setVisibility(0);
        }
    }
}
