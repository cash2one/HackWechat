package com.tencent.xweb.xwalk;

import android.content.Context;
import org.xwalk.core.XWalkView;

class h$a extends XWalkView {
    final /* synthetic */ h Atn;

    public h$a(h hVar, Context context) {
        this.Atn = hVar;
        super(context);
    }

    public final void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        super.onScrollChangedDelegate(i, i2, i3, i4);
        if (this.Atn.Arl != null) {
            this.Atn.Arl.onWebViewScrollChanged(i, i2, i3, i4);
        }
    }
}
