package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingContent extends FrameLayout {
    private int vrl = -1;
    private int vrm = 0;

    public ChattingContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ChattingContent", "jacks onMeasure  width:%d, height:%d", new Object[]{Integer.valueOf(MeasureSpec.getSize(i)), Integer.valueOf(MeasureSpec.getSize(i2))});
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ChattingContent", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onLayout(z, i, i2, i3, i4);
    }
}
