package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.OverScrolledListener;

class h$4 implements OverScrolledListener {
    final /* synthetic */ h Atn;

    h$4(h hVar) {
        this.Atn = hVar;
    }

    public final void onOverScrolled(boolean z) {
        if (z) {
            this.Atn.Atl = true;
        } else {
            this.Atn.Atl = false;
        }
    }
}
