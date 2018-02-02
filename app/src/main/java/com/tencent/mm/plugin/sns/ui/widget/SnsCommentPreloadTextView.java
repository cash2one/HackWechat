package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView extends PLTextView {
    private static a rRI = null;
    private static int rRJ = 0;

    public SnsCommentPreloadTextView(Context context) {
        super(context);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a Ef() {
        if (rRI == null) {
            rRI = b.bCD().bCE();
        }
        return rRI;
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
    }

    protected final void o(CharSequence charSequence) {
        super.o(charSequence);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
