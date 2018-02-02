package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class HighlightRectSideView$1 implements a {
    final /* synthetic */ HighlightRectSideView pVt;

    HighlightRectSideView$1(HighlightRectSideView highlightRectSideView) {
        this.pVt = highlightRectSideView;
    }

    public final boolean uF() {
        HighlightRectSideView.a(this.pVt);
        this.pVt.invalidate();
        return true;
    }
}
