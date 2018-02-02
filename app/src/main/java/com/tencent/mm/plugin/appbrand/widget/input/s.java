package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class s implements a {
    private int jYk = 0;
    private final Rect jYl = new Rect();
    private boolean jYm = false;
    private View jYn;
    a jYo;

    private void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.jYn != null) {
            this.jYn.getWindowVisibleDisplayFrame(rect);
        }
    }

    private Context getContext() {
        return this.jYn == null ? ac.getContext() : this.jYn.getContext();
    }

    private int amP() {
        if ((this.jYn == null ? null : this.jYn.getRootView()) == null) {
            return 0;
        }
        Rect rect = this.jYl;
        getWindowVisibleDisplayFrame(rect);
        return getContext().getResources().getDisplayMetrics().heightPixels - rect.top;
    }

    public final void bV(View view) {
        boolean p;
        Object obj = 1;
        this.jYn = view;
        Rect rect = this.jYl;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.jYk == 0) {
            this.jYk = height;
        } else {
            int amP = amP() - height;
            if (amP > 0) {
                if (j.aQ(getContext()) != amP) {
                    p = j.p(getContext(), amP);
                } else {
                    p = false;
                }
                if (!(!p || this.jYo == null || this.jYo.getHeight() == amP)) {
                    this.jYo.lX(amP);
                }
            }
        }
        if (amP() > height) {
            p = true;
        } else {
            p = false;
        }
        if (this.jYm == p) {
            obj = null;
        }
        if (!(obj == null || this.jYo == null)) {
            this.jYo.dw(p);
        }
        this.jYm = p;
        this.jYk = height;
        this.jYn = null;
    }
}
