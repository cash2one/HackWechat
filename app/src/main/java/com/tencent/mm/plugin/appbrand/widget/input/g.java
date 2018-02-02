package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.page.t;

public final class g {
    private static final g jXb = new g();
    private final a<t, Integer> jXa = new a();

    public static g amA() {
        return jXb;
    }

    final void n(t tVar) {
        if (tVar != null) {
            this.jXa.remove(tVar);
            tVar.getView().setFocusable(true);
            tVar.getView().setFocusableInTouchMode(true);
        }
    }

    public final void o(t tVar) {
        if (tVar != null) {
            Integer num = (Integer) this.jXa.get(tVar);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.jXa.put(tVar, Integer.valueOf(num.intValue() + 1));
            tVar.getView().setFocusable(false);
            tVar.getView().setFocusableInTouchMode(false);
        }
    }

    public final void p(t tVar) {
        if (tVar != null) {
            Integer num = (Integer) this.jXa.get(tVar);
            if (num != null) {
                num = Integer.valueOf(num.intValue() - 1);
                if (num.intValue() > 0) {
                    this.jXa.put(tVar, num);
                    return;
                }
            }
            n(tVar);
        }
    }
}
