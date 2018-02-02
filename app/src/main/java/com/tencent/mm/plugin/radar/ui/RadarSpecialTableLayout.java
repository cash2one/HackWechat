package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import b.c.b.e;

public final class RadarSpecialTableLayout extends TableLayout {
    private boolean pyJ;

    public RadarSpecialTableLayout(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarSpecialTableLayout(Context context) {
        e.i(context, "context");
        super(context);
    }

    public final void p(int i, int i2, int i3, int i4) {
        this.pyJ = true;
        super.layout(i, i2, i3, i4);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        if (this.pyJ || i2 >= 0) {
            z2 = false;
            i5 = 0;
        } else {
            i5 = i4 - i2;
            z2 = true;
        }
        this.pyJ = false;
        if (z2) {
            layout(i, 0, i3, i5);
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }
}
