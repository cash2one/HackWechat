package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;

final class a extends FrameLayout {
    public a(Context context, View view) {
        super(context);
        addView(view);
    }

    protected final void onMeasure(int i, int i2) {
        if ((getParent() instanceof View) && ((View) getParent()).getMeasuredHeight() > 0) {
            i2 = MeasureSpec.makeMeasureSpec(((View) getParent()).getMeasuredHeight() - com.tencent.mm.bv.a.fromDPToPix(getContext(), j.aS(getContext()) ? af.CTRL_BYTE : 24), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
