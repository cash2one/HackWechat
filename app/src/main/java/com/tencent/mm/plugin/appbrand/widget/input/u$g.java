package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.u.a;

final class u$g extends FrameLayout implements a {
    private boolean jYL = false;

    public u$g(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.ixG, this);
    }

    public final void cF(boolean z) {
        Object obj = z != this.jYL ? 1 : null;
        this.jYL = z;
        if (obj == null) {
            return;
        }
        if (VERSION.SDK_INT < 18 || !isInLayout()) {
            requestLayout();
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (this.jYL || !isShown()) {
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
