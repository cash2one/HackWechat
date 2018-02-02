package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;

class f$16 implements a {
    final /* synthetic */ f tpL;

    f$16(f fVar) {
        this.tpL = fVar;
    }

    public final boolean uF() {
        f.k(this.tpL);
        f.m(this.tpL).setText(this.tpL.getContext().getString(R.l.eCv, new Object[]{Integer.valueOf(f.l(this.tpL))}));
        if (f.l(this.tpL) > 0) {
            return true;
        }
        this.tpL.kh(true);
        return false;
    }
}
