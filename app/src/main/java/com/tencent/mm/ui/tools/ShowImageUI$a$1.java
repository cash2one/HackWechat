package com.tencent.mm.ui.tools;

import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.ui.tools.ShowImageUI.a;

class ShowImageUI$a$1 implements h {
    final /* synthetic */ MMAnimateView zna;
    final /* synthetic */ a znb;

    ShowImageUI$a$1(a aVar, MMAnimateView mMAnimateView) {
        this.znb = aVar;
        this.zna = mMAnimateView;
    }

    public final void invalidate() {
        this.zna.invalidate();
    }
}
