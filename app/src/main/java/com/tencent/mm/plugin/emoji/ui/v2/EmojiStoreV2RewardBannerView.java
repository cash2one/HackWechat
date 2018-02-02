package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class EmojiStoreV2RewardBannerView extends MMAnimateView {
    float gr = 0.75f;

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i3 = (int) (((float) right) * this.gr);
        if (right == 0 || i3 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
            i3 = (int) (((float) right) * this.gr);
        }
        setMeasuredDimension(right, i3);
    }
}
