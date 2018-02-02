package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMPullDownView;

public class CollectPullDownView extends MMPullDownView {
    public CollectPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollectPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void azz() {
        View inflate = inflate(this.context, g.uBv, null);
        View inflate2 = inflate(this.context, g.uBv, null);
        addView(inflate, 0, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        addView(inflate2, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
    }
}
