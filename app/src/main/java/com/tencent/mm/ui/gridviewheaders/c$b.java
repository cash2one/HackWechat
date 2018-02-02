package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

protected class c$b extends FrameLayout {
    final /* synthetic */ c zeG;
    int zeH;
    int zeI;

    public c$b(c cVar, Context context) {
        this.zeG = cVar;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        View view = (View) getTag();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(generateDefaultLayoutParams());
        }
        if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
            view.measure(MeasureSpec.makeMeasureSpec(this.zeI, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
        setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }
}
