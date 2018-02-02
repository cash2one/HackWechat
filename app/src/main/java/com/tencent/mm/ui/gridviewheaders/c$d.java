package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

protected class c$d extends FrameLayout {
    int mNumColumns;
    int mPosition;
    View[] zeF;
    final /* synthetic */ c zeG;
    private boolean zeK;

    public c$d(c cVar, Context context) {
        this.zeG = cVar;
        super(context);
    }

    public final Object getTag() {
        return getChildAt(0).getTag();
    }

    public final Object getTag(int i) {
        return getChildAt(0).getTag(i);
    }

    public final void setTag(int i, Object obj) {
        getChildAt(0).setTag(i, obj);
    }

    public final void setTag(Object obj) {
        getChildAt(0).setTag(obj);
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mNumColumns != 1 && c.b(this.zeG) != null) {
            if (this.mPosition % this.mNumColumns == 0 && !this.zeK) {
                this.zeK = true;
                for (View measure : this.zeF) {
                    measure.measure(i, i2);
                }
                this.zeK = false;
            }
            int measuredHeight = getMeasuredHeight();
            int i3 = measuredHeight;
            for (View view : this.zeF) {
                if (view != null) {
                    i3 = Math.max(i3, view.getMeasuredHeight());
                }
            }
            if (i3 != measuredHeight) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
        }
    }
}
