package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    protected final void axX() {
        this.nJi = new String[18];
        for (int i = 0; i < this.nJi.length; i++) {
            this.nJi[i] = Integer.toString(i + 3) + "劃";
        }
        this.nJg = 2.0f;
        this.nJh = 79;
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int aUq() {
        return R.i.dsD;
    }
}
