package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.be.1;
import com.tencent.mm.ui.MMActivity;

class be$1$1 extends b {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ LayoutParams jen;
    final /* synthetic */ 1 jeo;

    be$1$1(1 1, LayoutParams layoutParams, MMActivity mMActivity) {
        this.jeo = 1;
        this.jen = layoutParams;
        this.fgW = mMActivity;
    }

    public final void a(c cVar) {
        this.jen.screenBrightness = this.jeo.jem.jej;
        this.fgW.getWindow().setAttributes(this.jen);
    }

    public final void onResume() {
        this.jen.screenBrightness = this.jeo.jem.jek;
        this.fgW.getWindow().setAttributes(this.jen);
    }
}
