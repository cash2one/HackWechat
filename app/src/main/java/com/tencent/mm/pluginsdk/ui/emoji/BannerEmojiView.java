package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class BannerEmojiView extends MMAnimateView {
    public BannerEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BannerEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i3 = right / 2;
        if (right == 0 || i3 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
            i3 = right / 2;
        }
        setMeasuredDimension(right, i3);
    }
}
