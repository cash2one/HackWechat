package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.WebView;
import com.tencent.xweb.o;

class e$a extends WebView {
    final /* synthetic */ e Arw;
    public o juK;

    public e$a(e eVar, Context context) {
        this.Arw = eVar;
        super(context);
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.Arw.Arl != null) {
            this.Arw.Arl.onWebViewScrollChanged(i, i2, i3, i4);
        }
        if (this.juK != null) {
            this.juK.onScrollChanged(i, i2, i3, i4, this);
        }
    }
}
