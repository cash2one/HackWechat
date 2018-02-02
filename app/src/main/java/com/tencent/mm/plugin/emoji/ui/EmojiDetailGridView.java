package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    EmojiDetailScrollView lCn;
    private volatile boolean lCo = true;
    String lyH;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected final void ew(boolean z) {
        if (this.lCn != null) {
            this.lCn.lCp = z;
        }
    }

    protected final int aCT() {
        return 200;
    }
}
