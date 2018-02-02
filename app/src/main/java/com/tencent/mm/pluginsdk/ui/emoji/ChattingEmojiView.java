package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class ChattingEmojiView extends MMEmojiView {
    public ChattingEmojiView(Context context) {
        super(context);
        this.vsA = true;
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vsA = true;
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vsA = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
