package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.ac;

final class ag extends c {
    private static final int jZO = ac.getContext().getResources().getDimensionPixelSize(e.bvK);
    private com.tencent.mm.bx.e jZN = null;

    ag() {
    }

    protected final com.tencent.mm.bx.e ank() {
        if (this.jZN == null) {
            this.jZN = new a();
        }
        return this.jZN;
    }
}
