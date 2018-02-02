package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View xPN;
    private Runnable xPO = new Runnable(this) {
        final /* synthetic */ MMKeyboardUperView xPQ;

        {
            this.xPQ = r1;
        }

        public final void run() {
            this.xPQ.fullScroll(130);
            this.xPQ.xPN.setVisibility(4);
        }
    };
    private Runnable xPP = new 2(this);

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
