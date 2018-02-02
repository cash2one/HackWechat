package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewFrom extends RTChattingEmojiView {
    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public final void initView() {
        super.initView();
        this.vsQ.gravity = 3;
        addView(this.vsN, this.vsQ);
    }
}
