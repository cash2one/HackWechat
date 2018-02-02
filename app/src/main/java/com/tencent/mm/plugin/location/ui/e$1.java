package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e nTa;

    e$1(e eVar) {
        this.nTa = eVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (e.a(this.nTa)) {
            return false;
        }
        x.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        e.b(this.nTa);
        e.a(this.nTa, d2);
        e.b(this.nTa, (double) f2);
        e.c(this.nTa, (double) f);
        if (e.c(this.nTa) != null) {
            if (e.d(this.nTa)) {
                e.c(this.nTa).updateViewLayout(this.nTa, e.f(this.nTa), e.g(this.nTa), -2);
            } else {
                e.e(this.nTa);
                e.c(this.nTa).addView(this.nTa, e.f(this.nTa), e.g(this.nTa), -2);
            }
        }
        if (e.h(this.nTa) != null) {
            e.h(this.nTa).a(z, f, f2, i, d, d2, d3);
        }
        this.nTa.invalidate();
        this.nTa.postInvalidate();
        this.nTa.requestLayout();
        e.i(this.nTa);
        return true;
    }
}
