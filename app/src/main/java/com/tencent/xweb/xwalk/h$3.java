package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.ScrollChangedListener;

class h$3 implements ScrollChangedListener {
    final /* synthetic */ h Atn;

    h$3(h hVar) {
        this.Atn = hVar;
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        this.Atn.Ath.scrollTo(i, i2);
        if (this.Atn.juK != null) {
            this.Atn.juK.onScrollChanged(i, i2, i3, i4, this.Atn.Atc);
        }
    }
}
