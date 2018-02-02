package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q$d;
import com.tencent.mm.plugin.appbrand.q.g;

public final class a extends d {
    private static final int jau = g.iuA;

    public static a ce(View view) {
        return (a) view.getRootView().findViewById(jau);
    }

    public a(Context context) {
        super(context);
        super.setId(jau);
        setBackgroundResource(q$d.bsK);
        setOnClickListener(new 1(this));
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                bV(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setId(int i) {
    }

    public final void show() {
        super.show();
    }

    public final void hide() {
        super.hide();
    }
}
