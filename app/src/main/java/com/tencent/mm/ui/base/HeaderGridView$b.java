package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class HeaderGridView$b extends FrameLayout {
    final /* synthetic */ HeaderGridView xXQ;

    public HeaderGridView$b(HeaderGridView headerGridView, Context context) {
        this.xXQ = headerGridView;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec((this.xXQ.getMeasuredWidth() - this.xXQ.getPaddingLeft()) - this.xXQ.getPaddingRight(), 1073741824), i2);
    }
}
